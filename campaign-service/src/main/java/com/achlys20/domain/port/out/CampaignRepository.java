package com.achlys20.domain.port.out;

import com.achlys20.domain.model.Campaign;
import com.achlys20.domain.model.CampaignId;

import java.util.List;
import java.util.Optional;

public interface CampaignRepository {
    Campaign save(Campaign campaign);
    Optional<Campaign> findById(CampaignId id);
    List<Campaign> findAll();
    void deleteById(CampaignId id);
}