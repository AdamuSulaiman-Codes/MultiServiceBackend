package com.achlys20.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SpringDataCampaignRepository extends JpaRepository<CampaignEntity, UUID> {
}