package io.karon.discordbot

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
