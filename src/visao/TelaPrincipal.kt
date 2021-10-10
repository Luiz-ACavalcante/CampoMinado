package visao

import modelo.Tabuleiro
import modelo.TabuleiroEvento
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

fun main() {
    TelaPrincipal()
}

class TelaPrincipal : JFrame() {
    private val tabuleiro = Tabuleiro(qtdeColunas = 20,qtdeLinhas =  30,qtdeMinas = 60)
    private val painelTabuleiro = PainelTabuleiro(tabuleiro)

    init {
        tabuleiro.onEvento ( this::mostrarResultado )
        add(painelTabuleiro)

        setSize(600, 700)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        title = "Campo Minado"
        isVisible = true
    }
    private fun mostrarResultado(evento: TabuleiroEvento){
        SwingUtilities.invokeLater{
            val menssagem = when(evento) {
                TabuleiroEvento.VITORIA -> "Você ganhou !!!"
                TabuleiroEvento.DERROTA -> "Você perdeu\nTente novamente"
            }
            JOptionPane.showMessageDialog(this, menssagem)
            tabuleiro.reiniciar()

            painelTabuleiro.repaint()
            painelTabuleiro.validate()
        }
    }
}

