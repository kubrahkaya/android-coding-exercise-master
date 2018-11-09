package com.example.marsrobots.di.scopes

import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME

/**
 * Dagger application scope
 */
@Scope
@Retention(RUNTIME)
annotation class PerApplication
