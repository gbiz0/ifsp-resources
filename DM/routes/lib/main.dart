import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: const TelaInicial(),
      debugShowCheckedModeBanner: false,
    );
  }
}

// Nossa primeira tela (Tela A)
class TelaInicial extends StatelessWidget {
  const TelaInicial({super.key});
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Tela Inicial (A)'),
        backgroundColor: Colors.indigo,
        foregroundColor: Colors.white,
      ),
      body: Center(
        child: ElevatedButton(
          style: ElevatedButton.styleFrom(
            backgroundColor: Colors.indigo,
            foregroundColor: Colors.white,
            padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 15),
          ),
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => const TelaSecundaria()),
            );
          },
          child: const Text(
            'Ir para a Segunda Tela',
            style: TextStyle(fontSize: 18),
          ),
        ),
      ),
    );
  }
}

// Nossa segunda tela (Tela B)
class TelaSecundaria extends StatelessWidget {
  const TelaSecundaria({super.key});
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Tela Secundária (B)'),
        backgroundColor: Colors.purple,
        foregroundColor: Colors.white,
      ),
      body: Center(
        child: ElevatedButton(
          style: ElevatedButton.styleFrom(
            backgroundColor: Colors.purple,
            foregroundColor: Colors.white,
            padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 15),
          ),
          onPressed: () {
            Navigator.pop(context);
          },
          child: const Text(
            'Voltar para a Tela Inicial',
            style: TextStyle(fontSize: 18),
          ),
        ),
      ),
    );
  }
}