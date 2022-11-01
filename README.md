# Station-server-sdk
#### Document
- [Station Document](https://github.com/CrossEevery/station)
- [Station H5 SDK](https://github.com/CrossEevery/station-web-sdk)
- [Station H5 Editor SDK](https://github.com/CrossEevery/station-web-editor-sdk)

#### GET CODE
```aidl
git clone git@github.com:CrossEevery/station-server-sdk.git
```

#### Package
```aidl
mvn clean package -Dmaven.test.skip=true
```

#### Install Local Maven Repository
```aidl
mvn clean install -Dmaven.test.skip=true
```

#### Maven Quote
```aidl
<dependency>
  <groupId>com.actmos.station</groupId>
  <artifactId>station-server-sdk</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

#### Instance Admin Client
```aidl
StationConfig stationConfig = new StationConfig();
stationConfig.setEndpoint("CrossEvery Endpoint Address");
stationConfig.setKey("you publish key");
stationConfig.setSecurity("you private key");
StationAdminSDKClient  client = new StationAdminSDKClient(this.stationConfig);
```

#### Instance User Client
```aidl
StationConfig stationConfig = new StationConfig();
stationConfig.setEndpoint("CrossEvery Endpoint Address");
stationConfig.setKey("you publish key");
stationConfig.setSecurity("you private key");
StationUserSDKClient stationUserSDKClient = new StationUserSDKClient(stationConfig);
```