# converter-fastjson
fastjson converter for Retrofit2

converter-fastjson quick start
----------------------------------- 
```java
new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(FastjsonConverterFactory.create())
                .build();
```

add library

```
dependencies {
    compile 'com.wangqian:converter:0.0.3-beta3'
}
```
