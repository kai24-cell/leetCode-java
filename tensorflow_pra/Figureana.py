import tensorflow as tf
from tensorflow.keras import layers, models

# データ読み込み（TensorFlow内蔵）
(x_train, y_train), (x_test, y_test) = tf.keras.datasets.mnist.load_data()
x_train, x_test = x_train / 255.0, x_test / 255.0  # 正規化

# モデル構築
model = models.Sequential([
    layers.Flatten(input_shape=(28, 28)),
    layers.Dense(128, activation='relu'),
    layers.Dense(10, activation='softmax')
])

# コンパイル
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 学習
model.fit(x_train, y_train, epochs=5, validation_data=(x_test, y_test))
