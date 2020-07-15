package com.noxus.draven.hibernate.repository.second;

import com.noxus.draven.hibernate.entity.second.UserSecondEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecondRepository extends JpaRepository<UserSecondEntity, Long> {

}
