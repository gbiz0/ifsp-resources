import 'package:flutter/material.dart';

void main() => runApp(MeuApp());

class MeuApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: const VisitCard(),
    );
  }
}

class VisitCard extends StatelessWidget {
  const VisitCard({Key? key}) : super(key: key);

  static const String name = 'Linus Torvalds';
  static const String title = 'CRIADOR DO LINUX E DO GIT';
  static const String phone = '+55 17 12345 6789';
  static const String email = 'linus.torvalds@kernel.org';
  static const String avatarUrl =
      'https://avatars.githubusercontent.com/u/109951?v=4';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.teal,
      body: SafeArea(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const CircleAvatar(
              radius: 60.0,
              backgroundImage: NetworkImage(avatarUrl),
            ),
            const Text(
              name,
              style: TextStyle(
                fontFamily: 'Pacifico',
                fontSize: 40.0,
                color: Colors.white,
                fontWeight: FontWeight.bold,
              ),
            ),
            Text(
              title,
              style: TextStyle(
                fontFamily: 'Source Sans Pro',
                color: Colors.teal.shade100,
                fontSize: 20.0,
                letterSpacing: 2.5,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(
              height: 20.0,
              width: 150.0,
              child: Divider(color: Colors.tealAccent),
            ),
            ContactCard(icon: Icons.phone, contactText: phone),
            ContactCard(icon: Icons.email, contactText: email),
          ],
        ),
      ),
    );
  }
}

class ContactCard extends StatelessWidget {
  final IconData icon;
  final String contactText;

  const ContactCard({Key? key, required this.icon, required this.contactText})
    : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: const EdgeInsets.symmetric(vertical: 10.0, horizontal: 25.0),
      child: ListTile(
        leading: Icon(icon, color: Colors.teal),
        title: Text(
          contactText,
          style: TextStyle(
            color: Colors.teal.shade900,
            fontFamily: 'Source Sans Pro',
            fontSize: 20.0,
          ),
        ),
      ),
    );
  }
}
