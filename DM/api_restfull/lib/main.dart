import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class Afazer {
  final int id;
  final String titulo;
  final bool completado;

  const Afazer({
    required this.id,
    required this.titulo,
    required this.completado,
  });

  factory Afazer.fromJson(Map<String, dynamic> json) {
    return Afazer(
      id: json['id'],
      titulo: json['title'],
      completado: json['completed'],
    );
  }
}

class AfazerService {
  Future<List<Afazer>> buscarAfazeres() async {
    final url = Uri.parse('https://jsonplaceholder.typicode.com/todos');
    final response = await http.get(url);

    if (response.statusCode == 200) {
      final List<dynamic> listaJson = jsonDecode(response.body);
      return listaJson.map((json) => Afazer.fromJson(json)).toList();
    } else {
      throw Exception('Falha ao carregar os afazeres da API.');
    }
  }
}

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Lista de Afazeres',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const TelaAfazeres(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class TelaAfazeres extends StatefulWidget {
  const TelaAfazeres({super.key});

  @override
  State<TelaAfazeres> createState() => _TelaAfazeresState();
}

class _TelaAfazeresState extends State<TelaAfazeres> {
  late Future<List<Afazer>> _futureAfazeres;

  @override
  void initState() {
    super.initState();
    _futureAfazeres = AfazerService().buscarAfazeres();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Afazeres da API')),
      body: Center(
        child: FutureBuilder<List<Afazer>>(
          future: _futureAfazeres,
          builder: (context, snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return const CircularProgressIndicator();
            } else if (snapshot.hasError) {
              return Text('Erro: ${snapshot.error}');
            } else if (snapshot.hasData) {
              final afazeres = snapshot.data!;
              return ListView.builder(
                itemCount: afazeres.length,
                itemBuilder: (context, index) {
                  final afazer = afazeres[index];
                  return ListTile(
                    title: Text(afazer.titulo),
                    leading: Icon(
                      afazer.completado
                          ? Icons.check_circle
                          : Icons.radio_button_unchecked,
                      color: afazer.completado ? Colors.green : Colors.grey,
                    ),
                  );
                },
              );
            }
            return const Text('Nenhum afazer encontrado.');
          },
        ),
      ),
    );
  }
}
