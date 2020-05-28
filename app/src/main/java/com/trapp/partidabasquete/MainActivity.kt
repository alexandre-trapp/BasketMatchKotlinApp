package com.trapp.partidabasquete

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var pointsTeamA: Int = 0
    private var pointsTeamB: Int = 0

    private lateinit var scoreboardTeamA: TextView
    private lateinit var scoreboardTeamB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreboardTeamA = findViewById(R.id.placarTimeA)
        scoreboardTeamB = findViewById(R.id.placarTimeB)

        val (btThreePointsTeamA: Button,
             btTwoPointsTeamA: Button,
             bTFreeShotTeamA: Button) = createButtonsteamA()

        val (btThreePointsTeamB: Button,
             btTwoPointsTeamB: Button,
             bTFreeShotTeamB: Button) = createButtonsteamB()

        val btRestart: Button = createButtonRestart()

        setClickButtonsteamA(btThreePointsTeamA, btTwoPointsTeamA, bTFreeShotTeamA)

        setClickButtonsteamB(btThreePointsTeamB, btTwoPointsTeamB, bTFreeShotTeamB)

        btRestart.setOnClickListener { restartMatch() }
    }
    
    private fun createButtonsteamA(): Triple<Button, Button, Button> {

        val btThreePointsTeamA: Button = findViewById(R.id.tresPontosA)
        val btTwoPointsTeamA: Button = findViewById(R.id.doisPontosA)
        val bTFreeShotTeamA: Button = findViewById(R.id.tiroLivreA)
        return Triple(btThreePointsTeamA, btTwoPointsTeamA, bTFreeShotTeamA)
    }

    private fun createButtonsteamB(): Triple<Button, Button, Button>
    {
        val btThreePointsTeamB: Button = findViewById(R.id.tresPontosB)
        val btTwoPointsTeamB: Button = findViewById(R.id.doisPontosB)
        val bTFreeShotTeamB: Button = findViewById(R.id.tiroLivreB)
        return Triple(btThreePointsTeamB, btTwoPointsTeamB, bTFreeShotTeamB)
    }

    private fun createButtonRestart(): Button {

        val btRestart: Button = findViewById(R.id.reiniciarPartida)
        return btRestart
    }

    private fun setClickButtonsteamA(btThreePointsTeamA: Button,
        btTwoPointsTeamA: Button, bTFreeShotTeamA: Button) {

        btThreePointsTeamA.setOnClickListener { addPoints(3, "A") }
        btTwoPointsTeamA.setOnClickListener { addPoints(2, "A") }
        bTFreeShotTeamA.setOnClickListener { addPoints(1, "A") }
    }

    private fun setClickButtonsteamB(btThreePointsTeamB: Button,
        btTwoPointsTeamB: Button, bTFreeShotTeamB: Button) {

        btThreePointsTeamB.setOnClickListener { addPoints(3, "B") }
        btTwoPointsTeamB.setOnClickListener { addPoints(2, "B") }
        bTFreeShotTeamB.setOnClickListener { addPoints(1, "B") }
    }

    private fun addPoints(points: Int, team: String) {

        if ("A".equals(team))
            pointsTeamA += points
        else
            pointsTeamB += points

        refreshScoreboard(team)
    }

    private fun refreshScoreboard(team: String) {

        if ("A".equals(team))
            scoreboardTeamA.setText(pointsTeamA.toString())
        else
            scoreboardTeamB.setText(pointsTeamB.toString())
    }

    private fun restartMatch() {

        pointsTeamA = 0
        scoreboardTeamA.setText(pointsTeamA.toString())

        pointsTeamB = 0
        scoreboardTeamB.setText(pointsTeamB.toString())

        Toast.makeText(this, "Placar reiniciado", Toast.LENGTH_SHORT).show()
    }
}
