package com.example.demo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api")
class CameraController {

    @GetMapping("/getCamerasAIsAlarms")
    fun getCamerasAIsAlarms(): ResponseEntity<Any> {
        val fakeData = (1..5).map { index ->
            mapOf(
                "camera_id" to index,
                "camera_name" to "Camera $index",
                "camera_thumbnail" to "url_to_thumbnail_$index",
                "alarm_state" to listOf("on", "off", "auto").random(),
                "ai_enabled" to listOf(true, false).random(),
                "next_state_change" to LocalDate.now().plusDays(index.toLong())
            )
        }
        return ResponseEntity.ok(fakeData)
    }

    @GetMapping("/getCamerasAIsAlarmsLogs")
    fun getCamerasAIsAlarmsLogs(): ResponseEntity<Any> {
        val fakeLogs = (1..5).map { index ->
            mapOf(
                "camera_id" to index,
                "camera_name" to "Camera $index",
                "alteration_date" to LocalDate.now().minusDays(index.toLong()),
                "alarm_state" to listOf("on", "off", "auto").random(),
                "user_id" to index,
                "user_name" to "User $index"
            )
        }
        return ResponseEntity.ok(fakeLogs)
    }

    @PostMapping("/updateCamerasAIsAlarms")
    fun updateCamerasAIsAlarms(@RequestBody updates: List<CameraUpdateRequest>): ResponseEntity<Any> {
        // Aqui você pode simular uma atualização, mas como estamos trabalhando com dados falsos, retornaremos simplesmente os dados recebidos.
        return ResponseEntity.ok(updates)
    }
}

data class CameraUpdateRequest(
    val cameraId: Long,
    val alarmState: String
)
