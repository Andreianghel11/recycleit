import os
os.environ['TF_ENABLE_ONEDNN_OPTS'] = '0'

import tensorflow as tf
import keras
import numpy as np
from matplotlib import pyplot as plt

#also shuffles the data
#data = tf.keras.utils.image_dataset_from_directory('data')

# Eliminates bad data
# import cv2
# import imghdr

# data_dir = 'data' 
# image_exts = ['jpeg','jpg', 'bmp', 'png']

# for image_class in os.listdir(data_dir): 
#     for image in os.listdir(os.path.join(data_dir, image_class)):
#         image_path = os.path.join(data_dir, image_class, image)
#         try: 
#             img = cv2.imread(image_path)
#             tip = imghdr.what(image_path)
#             if tip not in image_exts: 
#                 print('Image not in ext list {}'.format(image_path))
#                 os.remove(image_path)
#         except Exception as e: 
#             print('Issue with image {}'.format(image_path))
#             #os.remove(image_path)

print(tf.__version__)
print(keras.__version__)

batch_size = 32
img_height = 180
img_width = 180

train_ds = keras.utils.image_dataset_from_directory(
    'data',
    validation_split=0.2,
    subset="training",
    seed=123,
    image_size=(img_height, img_width),
    batch_size=batch_size)


val_ds = keras.utils.image_dataset_from_directory(  
    'data',
    validation_split=0.2,
    subset="validation",
    seed=123,
    image_size=(img_height, img_width),
    batch_size=batch_size)

class_names = train_ds.class_names
print(class_names)

plt.figure(figsize=(10, 10))
for images, labels in train_ds.take(1):
    for i in range(9):
        ax = plt.subplot(3, 3, i + 1)
        plt.imshow(images[i].numpy().astype("uint8"))
        plt.title(class_names[labels[i]])
        plt.axis("off")

#plt.show()


for image_batch, labels_batch in train_ds:
  print(image_batch.shape)
  print(labels_batch.shape)
  break


# AUTOTUNE = tf.data.AUTOTUNE

# train_ds = train_ds.cache().prefetch(buffer_size=AUTOTUNE)
# val_ds = val_ds.cache().prefetch(buffer_size=AUTOTUNE)


num_classes = 10

model = keras.models.Sequential([
  keras.layers.Rescaling(1./255),
  keras.layers.Conv2D(32, 3, activation='relu'),
  keras.layers.MaxPooling2D(),
  keras.layers.Conv2D(32, 3, activation='relu'),
  keras.layers.MaxPooling2D(),
  keras.layers.Conv2D(32, 3, activation='relu'),
  keras.layers.MaxPooling2D(),
  keras.layers.Flatten(),
  keras.layers.Dense(128, activation='relu'),
  keras.layers.Dense(num_classes)
])

model.compile(
  optimizer='adam',
  loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
  metrics=['accuracy'])


model.fit(
  train_ds,
  validation_data=val_ds,
  epochs=20
)


# Scalare
#data = data.map(lambda x,y: (x/255, y))

# data_iterator = data.as_numpy_iterator()
# batch = data_iterator.next()
# batch[0].min()

# # Show images

# fig, ax = plt.subplots(ncols=10, figsize=(10,10))
# for idx, img in enumerate(batch[0][:10]):
#     ax[idx].imshow(img.astype(int))
#     ax[idx].title.set_text(batch[1][idx])
    
# plt.show()


# Split train, validare, test

# dataset_size = len(data)
# train_size = int(dataset_size * .7)
# validation_size = int(dataset_size * .2) + 1
# test_size = int(dataset_size * .1) + 1

# print(dataset_size)
# print(train_size, "\n", validation_size, "\n", test_size)

# train = data.take(train_size)
# remaining = data.skip(train_size)
# validation = remaining.take(validation_size)
# test = remaining.skip(validation_size)

# for images, labels in data:
#     print(labels)



# print("train")
# i = 0
# for images, labels in train:
#     i = i + 1
#     print(labels)
#     if i == 10:
#         break

# print("validation")
# i = 0
# for images, labels in validation:
#     i = i + 1
#     print(labels)
#     if i == 10:
#         break

# print("test")
# i = 0
# for images, labels in test:
#     i = i + 1
#     print(labels)
#     if i == 10:
#         break


