import tensorflow as tf

print(tf.config.list_physical_devices('GPU'))

# tf.test.is_built_with_cuda()
# tf.test.is_gpu_available(cuda_only=False, min_cuda_compute_capability=None)