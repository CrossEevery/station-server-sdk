package com.actmos.sdk.station.unittest;

import com.actmos.sdk.station.StationAdminSDKClient;
import com.actmos.sdk.station.common.DateUtil;
import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.station.*;
import com.actmos.sdk.station.exception.StationException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class StationSDKAdminUnitTest {

    private StationConfig stationConfig;
    private StationAdminSDKClient client;

    @Before
    public void buildBefore() {
        this.stationConfig = new StationConfig();
        stationConfig.setEndpoint("https://api.open.crossevery.com");
        stationConfig.setKey("you publish key");
        stationConfig.setSecurity("you private key");
        client = new StationAdminSDKClient(this.stationConfig);
    }

    @Test
    public void getUploadTempTokenUnitTest() {
        try {
            UploadTokenDTO dto = this.client.applyUploadToken();
            if (dto != null) {
                System.out.println(JsonUtil.simpleJson(dto));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (StationException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void uploadFileUnitTest() {
        String file = "you template file path";
        try {
            UploadTokenDTO dto = this.client.applyUploadToken();
            if (dto != null) {
                System.out.println(JsonUtil.simpleJson(dto));
                String eTag = this.client.uploadFile(file, dto);
                System.out.println(eTag);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (StationException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createStationTrilateralTemplateUnitTest() {
        StationTrilateralTemplateDTO stationTrilateralTemplateDTO = new StationTrilateralTemplateDTO();
        stationTrilateralTemplateDTO.setProjectPath("/1234/GFokfRS3rRpXMNS5ljnXQ34v7WYFOKv3.zip");
        stationTrilateralTemplateDTO.setPublishStartTime(new Date());
        stationTrilateralTemplateDTO.setPublishEndTime(DateUtil.addDays(new Date(), 365));
        stationTrilateralTemplateDTO.setName("????????????");
        stationTrilateralTemplateDTO.setInfo("??????????????????");
        stationTrilateralTemplateDTO.setTag("12,34");
        stationTrilateralTemplateDTO.setPhoto128("http://wwww.baidu.com");
        stationTrilateralTemplateDTO.setStock(1000);
        stationTrilateralTemplateDTO.setPrice(12);
        try {
            stationTrilateralTemplateDTO = this.client.applyStationTrilateralTemplate(stationTrilateralTemplateDTO);
            System.out.println(stationTrilateralTemplateDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void enableStationTrilateralTemplateUnitTest() {
        try {
            StationTrilateralTemplateDTO stationTrilateralTemplateDTO = this.client.enableStationTrilateralTemplate(15);
            if (stationTrilateralTemplateDTO != null) {
                System.out.println(stationTrilateralTemplateDTO);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void disableStationTrilateralTemplateUnitTest() {
        try {
            StationTrilateralTemplateDTO stationTrilateralTemplateDTO = this.client.disableStationTrilateralTemplate(15);
            if (stationTrilateralTemplateDTO != null) {
                System.out.println(stationTrilateralTemplateDTO);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void grantTemplateToUserUnitTest() {
        try {
            EnshrineDTO enshrine = this.client.grantTemplateToUser(15, "sdasdsdasda");
            if (enshrine != null) {
                System.out.println(enshrine);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void createStationUnitTest() {
        try {
            StationDTO temp = new StationDTO();
            temp.setName("????????????SDK??????????????????");
            temp.setUuid("xxxxxxxxxsdasdasdsdasd");
            temp.setStationDesc("?????????????????????????????????");
            temp.setTags("HI,HI");
            temp.setStationPhoto("www.baidu.com");
            temp.setHubType(2);
            temp.setAudioType(1);
            temp.setDeliveryType(1);
            temp.setPropertiesType(1);
            temp.setUserMode(2);
            temp.setEnshrineId(24);
            StationDTO station = this.client.createStation(temp);
            if (station != null) {
                System.out.println(station);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void grantStationTicketToUserUnitTest() {
        try {
            StationTicketDTO ticket = new StationTicketDTO();
            ticket.setToStationId(23);
            ticket.setToStationName("????????????SDK??????????????????");
            ticket.setName("???????????????");
            ticket.setFromStationId(0);
            ticket.setFromStationName("????????????");
            ticket.setUuid("xxxxxxxxxsdasdasdsdasd");
            ticket.setStartTime(DateUtil.addDays(new Date(), 1));
            ticket.setEndTime(DateUtil.addDays(new Date(), 265));
            ticket.setTicketType(StationTicketType.MULTIPASS.getType());
            ticket.setInfo("zxzxxzzx");
            ticket = this.client.grantStationTicketToUser(ticket);
            if (ticket != null) {
                System.out.println(ticket);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
