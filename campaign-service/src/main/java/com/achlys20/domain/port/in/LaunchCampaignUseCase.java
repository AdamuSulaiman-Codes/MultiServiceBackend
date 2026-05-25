package com.achlys20.domain.port.in;

import com.achlys20.domain.model.Campaign;
import com.achlys20.domain.model.CampaignId;

public interface LaunchCampaignUseCase {
    Campaign launchCampaign(CampaignId id);
}