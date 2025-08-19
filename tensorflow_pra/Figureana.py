import tensorflow as tf
import numpy as np

# XORデータ
x = np.array([[0,0],[0,1],[1,0],[1,1]])#入力
y = np.array([0,1,1,0])  # XORの答え

# モデル
model = tf.keras.Sequential([
    tf.keras.layers.Dense(8, activation="relu",input_shape=(2,)),
    tf.keras.layers.Dense(1, activation="sigmoid")
])

model.compile(optimizer="adam",
              loss="binary_crossentropy",
              metrics=["accuracy"])

model.fit(x, y, epochs=500, verbose=1)

print("予測:")
print(model.predict(x))
