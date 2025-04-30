package com.WebCraft.Cobra.repository;

import com.WebCraft.Cobra.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactMessage, Long> {
}
