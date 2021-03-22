package io.karon.discord_bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DiscordBotApplication

fun main(args: Array<String>) {
	runApplication<DiscordBotApplication>(*args)
}

/*
Message d’accueil personnalisable pour les nouveaux arrivants sur le serveur.
- message d'accueil oui, mais pas encore personnalisable via command

Auto-attribution de rôles par les membres avec le système de réactions visible sur #welcome .
- fonctionnel, reste la config spécifique
- configurable seulement dans le code

Creation de channel à la vollée
- thread avec id de message pour "reagir" sur un message
- thread sur un sujet general

Attribution d’Xp, avec système de niveaux personnalisables.
- meh, on verra plus tard, me faut une DB pour ça




rajouter commande pour quitter un thread, et si le dernier quitte on supprime le thread
RakopsToday at 1:35 PM
exporter le domaine dans un module à part
qui ne PEUT PAS appeler l'infra
nullobject pour les trucs genre les roles si on trouve pas
redecouper surement les repository et autres
l'ideal serait de dire "jai besoin de cette methode", et l'infra envoie juste ça
primitive obsession -> ne jamais passer de primitive, faut passer des functions ou des objets
RakopsToday at 1:47 PM
faut pouvoir recuperer la guilde plus facilement et l'envoyer là où on a besoin plutot que de faire message.guild.dosomething
imo
RakopsToday at 3:25 PM
on pourrait aussi avoir un emoji "thread", si tu reagis sur un message en mettant cet emoji, alors le bot crée un thread pour ça, il réécrit le message de la personne (pour avoir le contexte) et invite la personne qui a écrit le message et celle qui a réagit
et apres si quelqu'un d'autre clique sur l'emoji, ça lui donne aussi acces au thread
neonima — Today at 3:20 PM
Encore plus simple
Rakops — Today at 3:20 PM
comme ça tu passes meme pas par une commande
neonima — Today at 3:20 PM
:thread:
Rakops — Today at 3:20 PM
l'ideal serait d'avoir les deux selon moi
oh bonne idée !
neonima — Today at 3:21 PM
Faut pouvoir lier le bon message
:thread: 10
Rakops — Today at 3:21 PM
comment ça ?
neonima — Today at 3:21 PM
Ca reprendre les 10 derniers message
Rakops — Today at 3:21 PM
ah oui
neonima — Today at 3:21 PM
Les copie
Et les supprime
Rakops — Today at 3:22 PM
je pensais plutot a ce que je viens de faire sur ton message
et ça prendra que celui ci
mais pour la commande !thread (ou :thread: ) on pourrait ajouter un count aussi
neonima — Today at 3:22 PM
Ah je vois mais si tu te rends compte après coup que tu es parti en couille
Rakops — Today at 3:22 PM
qui supprime tout et réécris les messages
neonima — Today at 3:22 PM
Ce serait aussi un moyen simple de faire du ménage sur le chan
C’est ça
Yes cool cool
Rakops — Today at 3:23 PM
ouai, au pire on supprime pas les messages, deja les rajouter sur le nouveau thread serait cool
c'est tres faisable, je vais essayer de faire tout ça
RakopsToday at 4:50 PM
j'ai rajouté une feature pour pouvoir faire, n'importe ou :
!thread discussion ddd

et ça crée un channel textuel privé (que personne peut voir) nommé thread-discussion-ddd-1543

Et ensuite le bot poste un message et si tu réagis au message ça t'inclus dans ce thread privé et il devient visible pour toi
next step ça sera de pouvoir reagir direct sur un message avec :thread:  (thread) pour que le bot fasse la meme chose
nealith — Today at 4:48 PM
génial !
Rakops - 75 — Today at 4:48 PM
et les gens qui cliquent sur :thread: auront acces, les autres le verront pas
et next next step ça serait de pouvoir faire genre "!thread 10 ddd" et ça prendra les 10 derniers messages, ça les réécris dans ce nouveau thread, et peut etre que ça les supprime de là où t'es
pour, d'une certaine maniere, deplacer la conversation
et pas decouper la conv en deux
nealith — Today at 4:49 PM
et tu rajoute automatiquement les gens qui avaient écrit les messages
RakopsToday at 9:59 PM
fait des tests







Suggestions bot:
Liste des offres avec tag
- ! offer + réact avec des technos

Liste des recherches de poste avec tag
- ! search + réact avec des technos

Tout le monde peut ajouter jusqu'à 3 offres par défaut et le search envoit un message privé
ça permet de faire du matching !
! search all pour tout voir

Pourvoir configurer le command prefix par serveur

Pouvoir config son profil sur le bot, de façon à mettre des liens vers des sites tels que SO, Malt, Linkedin, etc
pouvoir y mettre notre prez
nos techno adorées
ce qu'on aime moins
localisation (remote compris)

system de votes pour la création de chans
ou la suppression :wink:

Suggestion : pouvoir en tant qu'admin dire au bot de delete tout les messages jusqu'a message en particulier, de facon à clean
quand il y a digression dans un chan en particulier, comme à partir de là : https://discord.com/channels/809425005863632946/819885814909239316/819972028723232818

si je dis pas de betises, on peut avoir des roles qui donnent acces à des channels.
Ca peut etre envisageable que le bot te permette de t'attribuer des roles ou t'en enlever pour avoir acces ou pas,
ce qui te permettrait de faire du tri dans les channels visibles. Et ca enleverait pas mal le probleme de "trop de channels" ^^

je sais pas si le bot peut creer des channels textuels. Si c'est le cas, tu pourrais faire de la creation à la vollée pour faire des threads, avec un role dédié, et quand le thread meurt tu fermes le thread

Pour le bot, je suis pour un système plus générique de listes d'items sur demande (offres, recherches, suggestions, votes...). Lecture par commande avec envoi en message privé + chan restreint avec liste à jour.
Chaque liste a une AllowList plus ou moins permissive pour l'écriture et/ou la lecture.
Ajout d'item par commande
Lecture de liste par commande
Lecture d'un item en particulier par commande
 */
