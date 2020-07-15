package com.noxus.draven.hibernate.repository.primary;

import com.noxus.draven.hibernate.entity.primary.UserPrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrimaryRepository extends JpaRepository<UserPrimaryEntity, Long> {

}
