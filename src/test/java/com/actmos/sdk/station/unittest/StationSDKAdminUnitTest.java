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
        stationConfig.setEndpoint("http://127.0.0.1:8888");
        stationConfig.setKey("1234");
        stationConfig.setSecurity("91754573fe83df46");
        client = new StationAdminSDKClient(this.stationConfig);
    }

    @Test
    public void getUploadTempTokenUnitTest() {
        System.out.println("----------------------");
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
    public void createStationTrilateralTemplateUnitTest() {
        StationTrilateralTemplateDTO stationTrilateralTemplateDTO = new StationTrilateralTemplateDTO();
        stationTrilateralTemplateDTO.setProjectPath("/1234/GFokfRS3rRpXMNS5ljnXQ34v7WYFOKv3.zip");
        stationTrilateralTemplateDTO.setPublishStartTime(new Date());
        stationTrilateralTemplateDTO.setPublishEndTime(DateUtil.addDays(new Date(), 365));
        stationTrilateralTemplateDTO.setName("测试一下");
        stationTrilateralTemplateDTO.setInfo("搞个单元测试");
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
            temp.setName("这是通过SDK创建的空间站");
            temp.setUuid("xxxxxxxxxsdasdasdsdasd");
            temp.setStationDesc("这是一个很牛逼的空间站");
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
            ticket.setToStationName("这是通过SDK创建的空间站");
            ticket.setName("官方发的票");
            ticket.setFromStationId(0);
            ticket.setFromStationName("平台发放");
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
