import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceListaDeTarefas {
    private static ArrayList<String> tarefas = new ArrayList<String>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            criarGUI();
        });
    }

    private static void criarGUI() {
        JFrame frame = new JFrame("Aplicativo de Lista de Tarefas");

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JButton adicionarButton = new JButton("Adicionar Tarefa");
        JButton removerButton = new JButton("Remover Tarefa");
        JButton listarButton = new JButton("Listar Tarefas");

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tarefa = JOptionPane.showInputDialog(frame, "Digite a tarefa a ser adicionada:");
                adicionarTarefa(tarefas, tarefa);
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String indiceStr = JOptionPane.showInputDialog(frame, "Digite o índice da tarefa a ser removida:");
                int indice = Integer.parseInt(indiceStr);
                removerTarefa(tarefas, indice);
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTarefas(tarefas);
            }
        });

        frame.add(adicionarButton);
        frame.add(removerButton);
        frame.add(listarButton);

        frame.setVisible(true);
    }

    private static void adicionarTarefa(ArrayList<String> tarefas, String tarefa) {
        tarefas.add(tarefa);
        JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso.");
    }

    private static void removerTarefa(ArrayList<String> tarefas, int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }

    private static void listarTarefas(ArrayList<String> tarefas) {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa na lista.");
        } else {
            StringBuilder lista = new StringBuilder("Lista de Tarefas:\n");
            for (String tarefa : tarefas) {
                lista.append("- ").append(tarefa).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }
}
