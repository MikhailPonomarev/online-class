package com.onlineclass.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener::class)
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @Column(unique = true)
    var email: String,

    @Column
    var lastName: String,

    @Column
    var firstName: String,

    @Column
    var middleName: String? = null,

    @Column
    var dateOfBirth: LocalDate? = null,

    @ManyToOne(targetEntity = Role::class)
    @JoinColumn
    var roleId: Int? = null,

    @CreatedDate
    var createdAt: LocalDate?,

    @LastModifiedDate
    var updatedAt: LocalDateTime?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as User
        return id == other.id && email == other.email
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }
}