package com.rustedcor.userservice.Models

import jakarta.persistence.*
import java.time.Instant
import java.time.LocalDateTime

@Table(name = "role")
@Entity
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(unique = true)
    val name: String,
    @Column(nullable = true)
    val description: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
){
    @PrePersist
    fun onPrePersist() {
        val now = LocalDateTime.now()
        createdAt = now
        updatedAt = now
    }

    @PreUpdate
    fun onPreUpdate() {
        updatedAt = LocalDateTime.now()
    }
}

