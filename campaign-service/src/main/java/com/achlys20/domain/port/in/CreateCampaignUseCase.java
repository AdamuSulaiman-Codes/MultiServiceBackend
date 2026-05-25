package com.achlys20.domain.port.in;

import com.achlys20.domain.model.Campaign;
import com.achlys20.domain.model.CampaignType;

public interface CreateCampaignUseCase {
    Campaign createCampaign(String name, String description, CampaignType type);
}