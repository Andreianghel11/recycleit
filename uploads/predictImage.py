import os
os.environ['TF_ENABLE_ONEDNN_OPTS'] = '0'

import tensorflow as tf
import keras
import numpy as np
from matplotlib import pyplot as plt
from keras.callbacks import EarlyStopping
from keras.preprocessing import image

model_path = '/mnt/d/Licenta/RecycleIT/recycleit/uploads/modelVGG16_2.tflite'
img_path = '/mnt/d/Licenta/RecycleIT/recycleit/uploads/image.png'

interpreter = tf.lite.Interpreter(model_path=model_path)
interpreter.allocate_tensors()

# Get input and output tensors
input_details = interpreter.get_input_details()
output_details = interpreter.get_output_details()

if not os.path.isfile(img_path):
    print(f'File {img_path} not found')
    exit()

# Load and preprocess the image
img = image.load_img(img_path, target_size=(224, 224))
img_array = image.img_to_array(img)
img_array = np.expand_dims(img_array, axis=0)

# Normalize the image (VGG16 expects images in the range 0-255)
img_array = keras.applications.vgg16.preprocess_input(img_array)

# Set the tensor to point to the input data to be inferred
interpreter.set_tensor(input_details[0]['index'], img_array)

# Run inference
interpreter.invoke()

# Extract the output data
output_data = interpreter.get_tensor(output_details[0]['index'])

# Check the output data
print("Raw output data:", output_data)

predicted_class = np.argmax(output_data, axis=1)

# Define your class names
class_names = ['Battery', 'Biological', 'Cardboard', 'Clothes', 'Glass', 'Metal', 'Paper', 'Plastic', 'Shoes', 'Trash']  # Replace with your actual class names

# Print the predicted class name
print(f'Predicted class name: {class_names[predicted_class[0]]}')

with open('result.txt', 'w') as file:
    file.write(class_names[predicted_class[0]])