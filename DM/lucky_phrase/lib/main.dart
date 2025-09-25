import 'dart:math';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: SorteDoDia(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class SorteDoDia extends StatefulWidget {
  const SorteDoDia({super.key});

  @override
  State<SorteDoDia> createState() => _SorteDoDiaState();
}

class _SorteDoDiaState extends State<SorteDoDia> {
  final List<String> _frasesDaSorte = [
    "Acredite em si mesmo e tudo será possível.",
    "A sorte favorece a mente preparada.",
    "Grandes realizações nascem de pequenos começos.",
    "Sua criatividade é a chave para o sucesso hoje.",
    "A paciência é uma virtude que traz grandes recompensas.",
    "Um novo começo está no seu horizonte.",
    "Oportunidades inesperadas surgirão em breve.",
    "Seu sorriso é o seu melhor cartão de visitas.",
    "Aprenda com o ontem, viva o hoje, tenha esperança no amanhã.",
    "A gentileza é uma linguagem que todos entendem.",
    "Você é mais forte do que pensa e mais capaz do que imagina.",
    "Um dia de cada vez constrói uma vida de sucesso.",
    "A persistência realiza o impossível.",
    "Siga seus sonhos, eles sabem o caminho.",
    "A felicidade não é um destino, é uma jornada.",
    "Hoje é um bom dia para ter um bom dia.",
    "A energia que você espalha é a mesma que você recebe.",
    "Não tenha medo de desistir do bom para perseguir o ótimo.",
    "A jornada de mil milhas começa com um único passo.",
    "O sucesso é a soma de pequenos esforços repetidos dia após dia.",
    "Você está no caminho certo para alcançar seus objetivos.",
    "Uma boa surpresa financeira está a caminho.",
    "Sua sabedoria interior the guiará para a decisão certa.",
    "O otimismo é o imã da felicidade.",
    "Confie no processo. Coisas boas levam tempo.",
    "Um gesto de amizade trará alegria ao seu dia.",
    "Sua determinação irá superar qualquer obstáculo.",
    "A simplicidade é o último grau de sofisticação.",
    "O conhecimento abre portas que a sorte não pode.",
    "Celebre suas pequenas vitórias hoje."
  ];

  String _fraseExibida = "";

  @override
  void initState() {
    super.initState();
    _fraseExibida = "Clique no botão para gerar sua sorte!";
  }

  void _gerarNovaFrase() {
    final random = Random();
    final index = random.nextInt(_frasesDaSorte.length);
    
    setState(() {
      _fraseExibida = _frasesDaSorte[index];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.deepPurple.shade100,
      appBar: AppBar(
        title: const Text('Sorte do Dia'),
        backgroundColor: Colors.deepPurple,
        foregroundColor: Colors.white,
      ),
      body: Center(
        child: Card(
          margin: const EdgeInsets.all(20.0),
          elevation: 8.0,
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: <Widget>[
                const CircleAvatar(
                  radius: 30,
                  backgroundImage: AssetImage('assets/images/empresario.jpg'),
                ),
                const SizedBox(height: 20),
                Image.asset('assets/images/macaco.jpg', height: 100),
                const SizedBox(height: 30),
                Text(
                  _fraseExibida,
                  textAlign: TextAlign.center,
                  style: const TextStyle(fontSize: 20, fontStyle: FontStyle.italic),
                ),
                const SizedBox(height: 30),
                ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.deepPurple,
                    foregroundColor: Colors.white,
                    padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 15),
                  ),
                  onPressed: _gerarNovaFrase,
                  child: const Text('GERAR NOVA SORTE', style: TextStyle(fontSize: 16)),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}