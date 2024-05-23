import os
os.environ['TF_ENABLE_ONEDNN_OPTS'] = '0'

import tensorflow as tf
import keras
import numpy as np
from matplotlib import pyplot as plt
from keras.callbacks import EarlyStopping
from keras.preprocessing import image

model = keras.models.load_model('/mnt/d/Licenta/RecycleIT/recycleit/uploads/modelVGG16V4.keras')

img_path = '/mnt/d/Licenta/RecycleIT/recycleit/uploads/image.png'

if (not os.path.isfile(img_path)):
    print(f'File {img_path} not found')
    exit()

img = image.load_img(img_path, target_size=(224, 224))

img_array = image.img_to_array(img)

img_array = np.expand_dims(img_array, axis=0)

# Normalize the image (VGG16 expects images in the range 0-255)
img_array = keras.applications.vgg16.preprocess_input(img_array)

predictions = model.predict(img_array)

predicted_class = np.argmax(predictions, axis=1)

class_names = ['battery', 'biological', 'cardboard', 'clothes', 'glass', 'metal', 'paper', 'plastic', 'shoes', 'trash']  # Replace with your actual class names
# print(f'Predicted class name: {class_names[predicted_class[0]]}')

with open('result.txt', 'w') as file:
    file.write(class_names[predicted_class[0]])