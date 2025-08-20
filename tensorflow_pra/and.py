import numpy as np
import tensorflow as tf

x1=np.array([[0,0],[0,1],[1,0],[1,1]],dtype=np.float32)
y1=np.array([0,0,0,1],dtype=np.float32)

model=tf.keras.Sequential([
    tf.keras.layers.Dense(8, activation="relu",input_shape=(2,)),
    tf.keras.layers.Dense(1,activation="sigmoid")
])

model.compile(optimizer="adam",
               loss="binary_crossentropy",
               metrics=["accuracy"])

model.fit(x1,y1,epochs=500,verbose=0)
print("予測")
print(model.predict(x1))