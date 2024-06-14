package com.onlineclass.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
open class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0L,

    @Column
    open var lastName: String,

    @Column
    open var firstName: String,

    @Column
    open var middleName: String? = null,

    @Column(unique = true)
    open var email: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as User
        return id == other.id
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + middleName.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }
}