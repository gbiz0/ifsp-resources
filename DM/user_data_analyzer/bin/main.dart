import 'dart:async';
import 'dart:collection';
import 'dart:convert';
import 'dart:math';

Future<String> buscarUsuarios() async {
  await Future.delayed(const Duration(seconds: 2));

  return '''
[
  {"nome": "Ana", "idade": 25, "cidade": "São Paulo"},
  {"nome": "Bruno", "idade": 32, "cidade": "Rio de Janeiro"},
  {"nome": "Carla", "idade": 25, "cidade": "São Paulo"},
  {"nome": "Daniel", "idade": 45, "cidade": "Belo Horizonte"},
  {"nome": "Eduarda", "idade": 29, "cidade": "Curitiba"}
]
''';
}

double media(List<int> valores) {
  if (valores.isEmpty) return 0.0;
  final soma = valores.fold<int>(0, (acc, v) => acc + v);
  return soma / valores.length;
}

Future<void> main() async {
  print('Aguardando dados...');

  final jsonString = await buscarUsuarios();
  final List<dynamic> usuariosDynamic = jsonDecode(jsonString);

  final List<Map<String, dynamic>> usuarios = usuariosDynamic
      .map<Map<String, dynamic>>((e) => Map<String, dynamic>.from(e))
      .toList();

  final totalUsuarios = usuarios.length;

  final cidades = HashSet<String>();
  for (final u in usuarios) {
    final cidade = u['cidade'] as String?;
    if (cidade != null) {
      cidades.add(cidade);
    }
  }
  final numCidadesUnicas = cidades.length;

  final idades = usuarios
      .map((u) => u['idade'])
      .where((v) => v is int)
      .cast<int>()
      .toList();
  final mediaIdades = media(idades);

  final random = Random();
  final indiceSorteado = random.nextInt(totalUsuarios);
  final usuarioDestaque = usuarios[indiceSorteado];

  print('Relatório de Usuários:');
  print('-------------------------');
  print('Total de usuários: $totalUsuarios');
  print('Número de cidades únicas: $numCidadesUnicas');
  print('Idade média: ${mediaIdades.toStringAsFixed(1)} anos');
  print('-------------------------');
  print('Usuário em Destaque:');
  print('Nome: ${usuarioDestaque['nome']}');
  print('Idade: ${usuarioDestaque['idade']}');
  print('Cidade: ${usuarioDestaque['cidade']}');
}
