package com.project.recycleit.services;

import com.project.recycleit.beans.RecyclingHistory;
import com.project.recycleit.beans.User;
import com.project.recycleit.beans.WasteItem;
import com.project.recycleit.dtos.RecyclingHistoryCreateDto;
import com.project.recycleit.dtos.RecyclingHistoryDto;
import com.project.recycleit.dtos.RecyclingHistoryUserDto;
import com.project.recycleit.dtos.UserDto;
import com.project.recycleit.exceptionHandler.ItemNotFoundException;
import com.project.recycleit.exceptionHandler.UserNotFoundException;
import com.project.recycleit.mappers.RecyclingHistoryMapper;
import com.project.recycleit.mappers.UserMapper;
import com.project.recycleit.repositories.RecyclingHistoryRepository;
import com.project.recycleit.repositories.UserRepository;
import com.project.recycleit.repositories.WasteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class RecyclingHistoryService {
    @Autowired
    private RecyclingHistoryRepository recyclingHistoryRepository;

    @Autowired
    private WasteItemRepository wasteItemRepository;

    @Autowired
    private UserRepository userRepository;

    public void addRecyclingHistory(RecyclingHistoryCreateDto recyclingHistoryCreateDto) {
        RecyclingHistory recyclingHistory = RecyclingHistoryMapper.toRecyclingHistory(recyclingHistoryCreateDto);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            recyclingHistory.setUser(user.get());
        }

        Optional<WasteItem> wasteItem = wasteItemRepository.findById(recyclingHistoryCreateDto.getWasteItemId());
        if (wasteItem.isEmpty()) {
            throw new ItemNotFoundException("Waste item not found");
        } else {
            recyclingHistory.setWasteItem(wasteItem.get());
        }
        recyclingHistoryRepository.save(recyclingHistory);
    }

    public List<RecyclingHistoryDto> getRecyclingHistory() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            Optional<List<RecyclingHistory>> recyclingHistory = recyclingHistoryRepository.findAllByUserUserId(user.get().getUserId());
            if (recyclingHistory.isEmpty()) {
                throw new UserNotFoundException("Recycling history not found");
            } else {
                return recyclingHistory.get().stream().map(RecyclingHistoryMapper::toRecyclingHistoryDto).toList();
            }
        }
    }

    public Page<RecyclingHistoryUserDto> getRecyclingHistoryUser(int page, int size) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByEmail(username);

        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            Pageable pageable = PageRequest.of(page, size);
            Page<RecyclingHistory> recyclingHistoryPage = recyclingHistoryRepository.findAllByUserUserIdOrderByTimestampDesc(user.get().getUserId(), pageable);

            return recyclingHistoryPage.map(RecyclingHistoryMapper::toRecyclingHistoryUserDto);
        }
    }

    public void deleteRecyclingHistory(Long id) {
        Optional<RecyclingHistory> recyclingHistory = recyclingHistoryRepository.findById(id);
        if (recyclingHistory.isEmpty()) {
            throw new ItemNotFoundException("Recycling history not found");
        } else {
            recyclingHistoryRepository.delete(recyclingHistory.get());
        }
    }
}
