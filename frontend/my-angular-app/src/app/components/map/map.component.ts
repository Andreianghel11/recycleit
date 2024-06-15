import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {LocationService} from "../../services/location.service";
import {LocationDto} from "../../dtos/location.dto";
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrl: './map.component.css'
})
export class MapComponent implements OnInit, AfterViewInit {
  latitude: number = 45;
  longitude: number = 45;
  zoom: number = 14;
  recyclingCenters: LocationDto[] = [];
  @ViewChild('mapContainer', { static: true }) mapContainer!: ElementRef;
  map!: google.maps.Map;

  constructor(private locationService: LocationService, private http: HttpClient) { }

  ngOnInit(): void {
    this.locationService.getCurrentLocation().then(position => {
      this.latitude = position.coords.latitude;
      this.longitude = position.coords.longitude;
      this.initializeMap();
    }).catch(error => {
      console.error('Error getting location', error);
    });
  }

  ngAfterViewInit(): void {
    if (this.latitude && this.longitude) {
      this.initializeMap();
    }
  }

  initializeMap(): void {
    const mapOptions: google.maps.MapOptions = {
      center: { lat: this.latitude, lng: this.longitude },
      zoom: this.zoom
    };
    this.map = new google.maps.Map(this.mapContainer.nativeElement, mapOptions);
    this.addMarker({ latitude: this.latitude, longitude: this.longitude, name: 'You are here' , type: "user"});
    this.loadRecyclingCenters();
  }

  loadRecyclingCenters(): void {
    this.locationService.getNearbyRecyclingCenters(this.latitude, this.longitude, 5000).subscribe((response: LocationDto[]) => {
      console.log('Recycling centers received:', response);
      this.recyclingCenters = response;
      this.recyclingCenters.forEach(center => this.addMarker(center));
    }, error => {
      console.error('Error fetching recycling centers', error);
    });
  }

  isValidLocation(center: LocationDto): boolean {
    const isValid = !isNaN(center.latitude) && !isNaN(center.longitude);
    if (!isValid) {
      console.error('Invalid center coordinates:', center);
    }
    return isValid;
  }

  addMarker(center: LocationDto): void {
    if (this.isValidLocation(center)) {
      console.log(`Adding marker at (${center.latitude}, ${center.longitude}): ${center.name}`);
      const position: google.maps.LatLngLiteral = { lat: center.latitude, lng: center.longitude };
      const marker = new google.maps.Marker({
        position,
        map: this.map,
        title: center.name,
        icon: center.type === 'user' ? 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png' : 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
      });

      const infoWindow = new google.maps.InfoWindow({
        content: this.getInfoWindowContent(center)
      });

      marker.addListener('click', () => {
        infoWindow.open(this.map, marker);
      });
    }
  }

  getIcon(type: string): string {
    switch (type) {
      case 'recyclingCenter':
        return 'assets/achievements/recyclerNovice.png';
      case 'market':
        return 'assets/waste/Plastic.png';
      case 'recyclingPoint':
        return 'assets/wasteBins.png';
      default:
        return 'assets/user.png';
    }
  }

  getInfoWindowContent(center: LocationDto): string {
    return `
       <div style="display: flex; align-items: center; justify-content: space-between; width: 250px;">
        <div style="width: 60px; min-width: 60px; height: 60px;">
          <img src="${this.getIcon(center.type)}" alt="${center.type}" style="width: 100%; height: 100%;">
        </div>
        <div style="color: #010144; font-family: sans-serif; font-size: medium; flex-grow: 1; text-align: center; padding: 0 10px;"> <!-- Change color here -->
        <strong>${center.name}</strong>
      </div>
      </div>
    `;
  }
}
