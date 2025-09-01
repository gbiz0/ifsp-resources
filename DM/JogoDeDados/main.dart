import 'dart:math';
import 'package:flutter/material.dart';

void main() => runApp(const DiceGameApp());

class DiceGameApp extends StatelessWidget {
  const DiceGameApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Jogo de Dados',
      theme: ThemeData(primarySwatch: Colors.blue),
      // MUDANÇA 1: Agora inicia com PlayerSetupScreen ao invés de DiceGameScreen
      home: const PlayerSetupScreen(),
    );
  }
}

// MUDANÇA 2: Nova tela adicionada para configuração dos jogadores
class PlayerSetupScreen extends StatefulWidget {
  const PlayerSetupScreen({super.key});

  @override
  State<PlayerSetupScreen> createState() => _PlayerSetupScreenState();
}

class _PlayerSetupScreenState extends State<PlayerSetupScreen> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _player1Controller = TextEditingController();
  final TextEditingController _player2Controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Configuração dos Jogadores')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                controller: _player1Controller,
                decoration: const InputDecoration(labelText: 'Nome do Jogador 1'),
                validator: (value) => value!.isEmpty ? 'Digite um nome' : null,
              ),
              const SizedBox(height: 16),
              TextFormField(
                controller: _player2Controller,
                decoration: const InputDecoration(labelText: 'Nome do Jogador 2'),
                validator: (value) => value!.isEmpty ? 'Digite um nome' : null,
              ),
              const Spacer(),
              ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState!.validate()) {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => DiceGameScreen(
                          player1Name: _player1Controller.text,
                          player2Name: _player2Controller.text,
                        ),
                      ),
                    );
                  }
                },
                style: ElevatedButton.styleFrom(minimumSize: const Size(double.infinity, 50)),
                child: const Text('Iniciar Jogo'),
              )
            ],
          ),
        ),
      ),
    );
  }
}

// MUDANÇA 3: DiceGameScreen agora recebe os nomes dos jogadores como parâmetros
class DiceGameScreen extends StatefulWidget {
  final String player1Name;
  final String player2Name;

  const DiceGameScreen({
    super.key,
    required this.player1Name,
    required this.player2Name,
  });

  @override
  State<DiceGameScreen> createState() => _DiceGameScreenState();
}

class _DiceGameScreenState extends State<DiceGameScreen> {
  final Random _random = Random();
  // MUDANÇA 4: Valores iniciais mudaram de [0,0,0] para [1,1,1]
  List<int> _player1Rolls = [1, 1, 1];
  List<int> _player2Rolls = [1, 1, 1];
  String _resultMessage = '';

  // MUDANÇA 5: Adicionado mapa com URLs das imagens dos dados
  final Map<int, String> diceImages = {
    1: 'https://i.imgur.com/1xqPfjc.png',
    2: 'https://i.imgur.com/5ClIegB.png',
    3: 'https://i.imgur.com/hjqY13x.png',
    4: 'https://i.imgur.com/CfJnQt0.png',
    5: 'https://i.imgur.com/6oWpSbf.png',
    6: 'https://i.imgur.com/drgfo7s.png',
  };

  int _calculateScore(List<int> rolls) {
    final sum = rolls.reduce((a, b) => a + b);
    final uniqueValues = rolls.toSet().length;

    if (uniqueValues == 1) {
      return sum * 3;
    } else if (uniqueValues == 2) {
      return sum * 2;
    } else {
      return sum;
    }
  }

  void _rollDice() {
    setState(() {
      _player1Rolls = List.generate(3, (_) => _random.nextInt(6) + 1);
      _player2Rolls = List.generate(3, (_) => _random.nextInt(6) + 1);

      final score1 = _calculateScore(_player1Rolls);
      final score2 = _calculateScore(_player2Rolls);

      if (score1 > score2) {
        // MUDANÇA 6: Usa os nomes dinâmicos dos jogadores ao invés de "Jogador 1" e "Jogador 2"
        _resultMessage = '${widget.player1Name} venceu! ($score1 x $score2)';
      } else if (score2 > score1) {
        _resultMessage = '${widget.player2Name} venceu! ($score2 x $score1)';
      } else {
        _resultMessage = 'Empate! Joguem novamente.';
      }
    });
  }

  // MUDANÇA 7: _buildPlayerColumn completamente reformulado para usar imagens
  Widget _buildPlayerColumn(String name, List<int> rolls) {
    return Expanded(
      child: Column(
        children: [
          Text(name, style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
          const SizedBox(height: 10),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: rolls.map((value) {
              return Padding(
                padding: const EdgeInsets.all(4.0),
                // Substituído Container com texto por Image.network
                child: Image.network(
                  diceImages[value]!,
                  width: 50,
                  height: 50,
                  errorBuilder: (context, error, stackTrace) =>
                      const Icon(Icons.error, size: 40),
                ),
              );
            }).toList(),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Jogo de Dados')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            Row(
              children: [
                // MUDANÇA 8: Usa os nomes dinâmicos dos jogadores
                _buildPlayerColumn(widget.player1Name, _player1Rolls),
                _buildPlayerColumn(widget.player2Name, _player2Rolls),
              ],
            ),
            const SizedBox(height: 20),
            Text(
              _resultMessage,
              style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              textAlign: TextAlign.center,
            ),
            const Spacer(),
            ElevatedButton(
              onPressed: _rollDice,
              style: ElevatedButton.styleFrom(minimumSize: const Size(double.infinity, 50)),
              child: const Text('Jogar Dados'),
            ),
          ],
        ),
      ),
    );
  }
}

/*

Resumo das Mudanças Necessárias:
1. Estrutura da Aplicação

Adicionar a classe PlayerSetupScreen para entrada dos nomes
Modificar o home em MaterialApp para iniciar com PlayerSetupScreen

2. Modificar DiceGameScreen

Adicionar parâmetros player1Name e player2Name no construtor
Tornar obrigatórios estes parâmetros com required

3. Valores Iniciais

Alterar de [0, 0, 0] para [1, 1, 1]

4. Sistema de Imagens

Adicionar o mapa diceImages com as URLs das imagens
Modificar completamente o método _buildPlayerColumn() para usar Image.network() ao invés de Container com texto

5. Nomes Dinâmicos

Usar widget.player1Name e widget.player2Name ao invés de strings fixas
Aplicar tanto no _buildPlayerColumn() quanto nas mensagens de resultado

6. Navegação

Implementar navegação entre telas usando Navigator.push()
Adicionar validação de formulário na tela de configuração

7. Tratamento de Erros

Adicionar errorBuilder no Image.network() para casos de falha no carregamento das imagens

*/