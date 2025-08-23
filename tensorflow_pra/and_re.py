import pandas as pd
import numpy as np
import tensorflow as tf

# CSVを読み込み
df = pd.read_csv("and_data.csv")

# 入力データと教師データに分ける
x = df[["feature1", "feature2"]].values.astype(np.float32)  # 2列 → 入力
y = df["label"].values.astype(np.float32)                   # 1列 → 出力

# モデル構築
model = tf.keras.Sequential([
    tf.keras.layers.Dense(8, activation="relu", input_shape=(2,)),
    tf.keras.layers.Dense(1, activation="sigmoid")
])

# コンパイル
model.compile(optimizer="adam",
              loss="binary_crossentropy",
              metrics=["accuracy"])

# 学習
model.fit(x, y, epochs=500, verbose=0)

# 予測
print("予測結果:")
print(model.predict(x))
