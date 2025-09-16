import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: TelaPerfil(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class TelaPerfil extends StatelessWidget {
  const TelaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    const double bannerHeight = 240;
    const double avatarRadius = 70;
    const double avatarTop = bannerHeight - avatarRadius;

    return Scaffold(
      body: ListView(
        padding: EdgeInsets.zero,
        children: <Widget>[
          // 1. SOBREPOSIÇÃO: Stack para empilhar banner e avatar
          Stack(
            clipBehavior: Clip.none,
            alignment: Alignment.center,
            children: <Widget>[
              // Banner superior
              Container(
                height: bannerHeight,
                decoration: BoxDecoration(
                  gradient: LinearGradient(
                    colors: [Colors.blue.shade300, Colors.blue.shade800],
                    begin: Alignment.topLeft,
                    end: Alignment.bottomRight,
                  ),
                ),
              ),
              // 2. POSICIONAMENTO DO AVATAR: Positioned para posicionar o avatar
              Positioned(
                top: avatarTop,
                child: CircleAvatar(
                  radius: avatarRadius,
                  backgroundColor: Colors.white,
                  child: const CircleAvatar(
                    radius: 65,
                    backgroundImage: NetworkImage('https://avatars.githubusercontent.com/u/69866294?v=4'),
                  ),
                ),
              ),
            ],
          ),
          const SizedBox(height: 80),
          // 3. INFORMAÇÕES DO USUÁRIO
          const Text(
            'Gustavo Bizo',
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          Text(
            'Fernandópolis, Brasil',
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 18, color: Colors.grey.shade700),
          ),
          const SizedBox(height: 24),
          // 4. ESTATÍSTICAS
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              Column(
                children: const [
                  Text('16', style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
                  SizedBox(height: 4),
                  Text('Fotos', style: TextStyle(color: Colors.grey)),
                ],
              ),
              Column(
                children: const [
                  Text('2.345', style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
                  SizedBox(height: 4),
                  Text('Seguidores', style: TextStyle(color: Colors.grey)),
                ],
              ),
              Column(
                children: const [
                  Text('189', style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
                  SizedBox(height: 4),
                  Text('Seguindo', style: TextStyle(color: Colors.grey)),
                ],
              ),
            ],
          ),
          const SizedBox(height: 24),
          // 5. BOTÃO DE AÇÃO
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 24.0),
            child: GestureDetector(
              onTap: () {
                print('Botão Seguir pressionado!');
              },
              child: Container(
                padding: const EdgeInsets.all(16),
                decoration: BoxDecoration(
                  color: Colors.blue.shade700,
                  borderRadius: BorderRadius.circular(12),
                ),
                child: const Center(
                  child: Text(
                    'SEGUIR',
                    style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold, fontSize: 16),
                  ),
                ),
              ),
            ),
          ),
          const SizedBox(height: 24),
          // 6. GALERIA DE FOTOS
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
              Expanded(
                child: Container(
                height: 120,
                decoration: BoxDecoration(
                  color: Colors.grey.shade300,
                  borderRadius: BorderRadius.circular(8),
                  image: const DecorationImage(
                  image: NetworkImage('https://images.unsplash.com/photo-1506744038136-46273834b3fb'),
                  fit: BoxFit.cover,
                  ),
                ),
                ),
              ),
              const SizedBox(width: 8),
              Expanded(
                child: Container(
                height: 120,
                decoration: BoxDecoration(
                  color: Colors.grey.shade300,
                  borderRadius: BorderRadius.circular(8),
                  image: const DecorationImage(
                  image: NetworkImage('https://images.unsplash.com/photo-1465101046530-73398c7f28ca'),
                  fit: BoxFit.cover,
                  ),
                ),
                ),
              ),
              const SizedBox(width: 8),
              Expanded(
                child: Container(
                height: 120,
                decoration: BoxDecoration(
                  color: Colors.grey.shade300,
                  borderRadius: BorderRadius.circular(8),
                  image: const DecorationImage(
                  image: NetworkImage('https://images.unsplash.com/photo-1519125323398-675f0ddb6308'),
                  fit: BoxFit.cover,
                  ),
                ),
                ),
              ),
              ],
            ),
            ),
        ],
      ),
    );
  }
}