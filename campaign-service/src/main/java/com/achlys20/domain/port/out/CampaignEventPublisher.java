package com.achlys20.domain.port.out;

import com.achlys20.domain.model.Campaign;

public interface CampaignEventPublisher {
    void publishCampaignLaunched(Campaign campaign);
    void publishCampaignPaused(Campaign campaign);
}