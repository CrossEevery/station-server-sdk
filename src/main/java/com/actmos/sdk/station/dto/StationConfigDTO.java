package com.actmos.sdk.station.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StationConfigDTO implements Serializable {
    private StationFunctionButtonDTO buttons;
    private StationConfigMessageDTO message;
    private StationConfigAudioDTO audio;
    private StationPipelineDTO pipeline;
    private StationConfigCharacterDTO character;
    private StationOnlineServerDTO onlineServer;
    private List<StationDeliveryDTO> deliveryServer;
    private List<StationSlotDTO> slots;
    private StationStatisticsDTO stationStatistics;
    private List<StationAbilityDTO> ability;
}
