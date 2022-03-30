/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 28, 2022
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Development;

@Repository
public interface DevelopmentRepository extends JpaRepository<Development, Long> {
	
}
