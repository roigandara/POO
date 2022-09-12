package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		
		//La lista de los usuarios que forman parte de la red social
		// esto es como una base de datos, al borrar usuarios se borran de aqui. se borran tambien sus post/comentarios y los comentarios de otros en sus posts
		List<User>usersList = new ArrayList<>();
		List<Comment> emptyCommentList = new ArrayList<>();
		
		
		// ------- PRESETS
		//Usuarios
		User pepe = new User("pepe");
		User manolita = new User("manolita");
		User juan = new User("juan");
		User julia = new User("julia");
		User sandra = new User("sandra");
		User diego = new User("diego");
		User carlos = new User("carlos");
		
		//Listas de seguidores de pepe
		List<User> followedpepe = new ArrayList<>();
		followedpepe.add(manolita);
		followedpepe.add(diego);
		//seguidores de manolita
		List<User> followedmanolita = new ArrayList<>();
		followedmanolita.add(juan);
		followedmanolita.add(diego);		
		
		//post de pepe
		Post imagpepe = new ImagePost(LocalDate.of(2022, 5, 4),new ArrayList<Comment>(), "Selfie.jpg", 400, 450);
		Post textpepe = new TextPost(LocalDate.of(2022, 4, 1), new ArrayList<Comment>(), "Hoy salí de acampada");
		List<Post> postlistpepe = new ArrayList<>();
		postlistpepe.add(imagpepe);
		postlistpepe.add(textpepe);
		
		//comentarios de diego y manolita en el post de pepe
		Comment commenttextpepediego = new Comment("Menuda suerte", LocalDate.of(2022, 4, 2), diego);
		Comment commenttextpepemanolita = new Comment("Espero que no lloviese", LocalDate.of(2022, 4, 2), manolita);
		List<Comment>commentlist = new ArrayList<>();
		commentlist.add(commenttextpepemanolita);
		commentlist.add(commenttextpepediego);
		//añadimos los comentarios al post de pepe
		textpepe.setPostCommentList(commentlist);
		//añadimos la lista de post a pepe
		pepe.setPostList(postlistpepe);
		
		//añadimos amigos de pepe a pepe
		pepe.setFollowList(followedpepe);
		//añadimos amigos de manolita a manolita
		manolita.setFollowList(followedmanolita);
		
		//añadimos los usuarios a la lista de usuarios de la red social
		usersList.add(diego);
		usersList.add(carlos);
		usersList.add(pepe);
		usersList.add(manolita);
		usersList.add(julia);
		usersList.add(sandra);
		usersList.add(juan);
		
		UserList userList = new UserList (new ArrayList<User>());
		userList.setUserList(usersList);
		
		
		// MENÚ -------------
		
		
		// USUARIO BASE SE FORA NECESARIO, USASE JUAN POR COMODIDADE
		// User root = new User("root");
		
		
		// loguearse fora
		User currentUser = juan;
		User targetUser = null;
		
		
		String option = "";
		
		// do while
		do {
			String input = "";
			System.out.println("--- Está vostede logueado como: " + currentUser.getName() + " ---");
			System.out.println("--- MENU ---");
			System.out.println("Opcións: \n 1. Cambiar de usuario \n 2. Seguir a un usuario \n 3. Deixar de seguir a un usuario" +
			" \n 4. Engadir usuario, post ou comentario  \n 5. Listar posts de un usuario \n " +
			" 6. Listar comentarios de un usuario \n 7. Amosar número de comentarios de un post \n 8. Eliminar usuario, post ou comentario");
			System.out.println();
			option = Input.string("Seleccion: ¿Que opción desexa facer?: ");
			System.out.println();
			switch (option) {
				case "1":
					// Login usuario
					input = Input.string("Indica o nome do usuario co que iniciar sesión: ");
					currentUser = userList.findUserByName(input);
				break;
				case "2":
					input = (Input.string("Indica o nome do usuario a comezar a seguir: "));
					if (userList.findUserByName(input) != null) {
						currentUser.follow(userList.findUserByName(input));
						System.out.println(currentUser.followList);
					} else {
						System.out.println("Non existe ese usuario");
					}
				break;
				case "3":
					input = (Input.string("Indica o nome do usuario a deixar de seguir: "));
					if (userList.findUserByName(input) != null) {
						currentUser.unfollow(userList.findUserByName(input));
					} else {
						System.out.println("Non existe ese usuario");
					}
				break;
				case "4":
					option = Input.string("1. Engadir usuario \n 2. Añadir post \n 3. Añadir comentario \n Seleccion: ¿Que opción desexa facer?: ");
					switch (option) {
					case "1":
						input = Input.string("Indica o nome do usuario a engadir: ");
						if (userList.findUserByName(input) == null) {
							userList.addUser(input);
							usersList.add(userList.findUserByName(input));
							System.out.println("usuario engadido");
						} else {
							System.out.println("usuario xa existente");
						}
					case "2":
						option = Input.string("1. texto \n 2. imaxe \n 3. vídeo \n Selección: indica tipo de post");
						switch (option) {
						case "1":
							String text = Input.string("Escriba el texto del post: ");
							TextPost newTextPost = new TextPost(LocalDate.now(), emptyCommentList, text);
							currentUser.postList.add(newTextPost);
							System.out.println("Post creado.");
						case "2":
							String imageTitle = Input.string("Escriba el título de la imagen: ");
							int imageWidth = Input.integer("Escriba la anchura de la imagen: ");
							int imageHeight = Input.integer("Escriba la altura de la imagen: ");
							ImagePost newImagePost = new ImagePost(LocalDate.now(), emptyCommentList, imageTitle, imageWidth, imageHeight);
							currentUser.postList.add(newImagePost);
							System.out.println("Post creado.");
						case "3":
							String videoTitle = Input.string("Escriba el título del vídeo: ");
							String videoQuality = Input.string("Escriba la calidad del vídeo: ");
							int videoDuration = Input.integer("Escriba la duración del vídeo: ");
							VideoPost newVideoPost = new VideoPost(LocalDate.now(), emptyCommentList, videoTitle, videoQuality, videoDuration);
							currentUser.postList.add(newVideoPost);
							System.out.println("Post creado.");
						}
					}
				break;
				case "5":
					input = Input.string("Indica o nome do usuario do que listar as publicacións: ");
					targetUser = userList.findUserByName(input);
					if (targetUser != null) {
						targetUser.postsList();
					} else {
						System.out.println("Non existe ese usuario");
					}
				break;
				case "6":
					input = Input.string("Indica o nome do usuario do que listar os comentarios: ");
					targetUser = userList.findUserByName(input);
					if (targetUser != null) {
						for (User u : userList.getUserList()) {
							for (Post p : u.getPostList()) {
								p.listComments(targetUser);
							}
						}
						targetUser.postsList();
					} else {
						System.out.println("Non existe ese usuario");
					}
					
				break;
				case "7":
					input = Input.string("Indica o nome do usuario do que listar as publicacións: ");
					targetUser = userList.findUserByName(input);
					if (targetUser != null) {
						targetUser.postsList();
						int numPost = Input.integer("Indica o número do post do que amosar o número de comentarios: ");
						Post targetPost = targetUser.getPost(numPost-1);
						// Faltaría check de existencia
						System.out.println("Número de comentarios: " + targetPost.countComments());
					} else {
						System.out.println("Non existe ese usuario");
					}
				break;
				case "8":
					option = Input.string("1. usuario \n 2. post \n 3. comentarios \n Selección: ");
					switch (option) {
					case "1":
						input = Input.string("Escriba usuario a eliminar: ");
						userList.deleteUser(input);
					case "2":
						input = Input.string("Indica o nome do usuario do que listar as publicacións: ");
						targetUser = userList.findUserByName(input);
						if (targetUser != null) {
							targetUser.postsList();
							int numPost = Input.integer("Indica o número do post que eliminar: ");
							Post targetPost = targetUser.getPost(numPost-1);
							// Faltaría check de existencia
							targetPost.deletePost(targetUser, numPost);
							// ^ esto es como mucho workaround, ¿cuál es la mejor manera de utilizar un método sin necesidad de un objeto específico, static?
						} else {
							System.out.println("Non existe ese usuario");
						}
					case "3":
						String videoTitle = Input.string("Escriba el título del vídeo: ");
						String videoQuality = Input.string("Escriba la calidad del vídeo: ");
						int videoDuration = Input.integer("Escriba la duración del vídeo: ");
						VideoPost newVideoPost = new VideoPost(LocalDate.now(), emptyCommentList, videoTitle, videoQuality, videoDuration);
						currentUser.postList.add(newVideoPost);
						System.out.println("Post creado.");
				break;
			}
		} 
		
	} while (option != "end");
}
}
