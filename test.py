import tensorflow as tf

dataset = tf.data.Dataset.range(100)

train_size = 20
valid_size = 30
test_size = 50

train = dataset.take(train_size)
remaining = dataset.skip(train_size)
valid = remaining.take(valid_size)
test = remaining.skip(valid_size)

for i in train:
    print(i)

print("\n\n")

for i in valid:
    print(i)

print("\n\n")

for i in test:
    print(i)