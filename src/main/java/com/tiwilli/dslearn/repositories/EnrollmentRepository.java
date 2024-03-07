package com.tiwilli.dslearn.repositories;

import com.tiwilli.dslearn.dto.UserDTO;
import com.tiwilli.dslearn.entities.Enrollment;
import com.tiwilli.dslearn.entities.Offer;
import com.tiwilli.dslearn.entities.User;
import com.tiwilli.dslearn.entities.pk.EnrollmentPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {

    @Query("""
            SELECT DISTINCT obj FROM Enrollment obj
            WHERE obj.id.user.id = :userId
                        
            """)
    List<Enrollment> searchByUser(Long userId);

}
