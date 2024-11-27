package com.rustedcor.userservice.Models

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Table(name = "users")
@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    var firstName: String,
    var lastName: String,
    @Column(unique = true)
    var email: String,
    @ManyToOne(fetch = FetchType.LAZY)
    var role: Role,
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
