package com.jsp.hibernate.shopping_cart.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.shopping_cart.entity.Cart;
import com.jsp.hibernate.shopping_cart.entity.Product;
import com.jsp.hibernate.shopping_cart.entity.User;

public class ShoppingCartDao {

	public static Session getSession() {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Cart.class);
		cfg.addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		return session;

	}

	public static void addProduct(int productId, String productName, String productBrand, int productPrice) {

		Scanner sc = new Scanner(System.in);

		Product product = new Product();
		System.out.println("Enter the Product Id");
		product.setProductId(sc.nextInt());
		System.out.println("Enter the Product Name");
		product.setProductName(sc.next());
		System.out.println("Enter the Product Brand");
		product.setProductBrand(sc.next());
		System.out.println("Enter the Product Price");
		product.setProductPrice(sc.nextInt());

		Session session = getSession();
		Transaction tran = session.beginTransaction();

		session.save(product);
		tran.commit();
		session.close();

	}

	public static void addUserWithCart(int userid, String userName, String userEmail, int userAge, String userCity,
			int cartId) {

		Scanner sc = new Scanner(System.in);

		User user = new User();
		System.out.println("Enter the user Id");
		user.setUserid(sc.nextInt());
		System.out.println("Enter the user Name");
		user.setUserName(sc.next());
		System.out.println("Enter the user EmailId");
		user.setUserEmail(sc.next());
		System.out.println("Enter the user Age");
		user.setUserAge(sc.nextInt());
		System.out.println("Enter the user City");
		user.setUserCity(sc.next());

		Cart cart = new Cart();
		System.out.println("Enter the Cart Id");
		cart.setCartId(sc.nextInt());
		user.setCart(cart);

		Session session = getSession();
		Transaction tran = session.beginTransaction();

		session.save(user);
		session.save(cart);
		tran.commit();
		session.close();

	}

	public static void addProductIntocart() {

		Scanner sc = new Scanner(System.in);

		Session session = getSession();

		Transaction tran = session.beginTransaction();

		System.out.println("enter the Product Id:");

		Product existingProduct = session.get(Product.class, sc.nextInt());

		if (existingProduct != null) {

			System.out.println("Enter User Id:");

			User existinguser = session.get(User.class, sc.nextInt());

			if (existinguser != null) {

				Cart cart = existinguser.getCart();

				List<Product> pList = cart.getProducts();

				pList.add(existingProduct);

				session.update(cart);

			} else {

				System.err.println("User Not Fount");
			}
		} else {

			System.err.println("product not Found  !!");

		}

		tran.commit();
		session.close();
	}

	public static void removeProductFromCart() {

		Scanner sc = new Scanner(System.in);

		Session session = getSession();

		Transaction tran = session.beginTransaction();

		System.out.println("enter the User Id:");

		User existinguser = session.get(User.class, sc.nextInt());

		if (existinguser != null) {

			System.out.println("Enter product Id:");

			Product existingProduct = session.get(Product.class, sc.nextInt());

			if (existingProduct != null) {

				Cart cart = existinguser.getCart();

				List<Product> pList = cart.getProducts();

				if (pList.contains(existingProduct)) {

					pList.remove(existingProduct);

					session.update(cart);
					System.out.println("Removed Successfully");

				} else {

					System.err.println("Product Not Fount");
				}
			} else {

				System.err.println("product not Found in DataBase !!");

			}
		}

		else {
			System.out.println("user not Found  !!");

		}

		tran.commit();
		session.close();

	}

	public static void findAllProductFromCart() {

		Scanner sc = new Scanner(System.in);

		Session session = getSession();

		Transaction tran = session.beginTransaction();

		System.out.println("enter the User Id:");

		User existinguser = session.get(User.class, sc.nextInt());

		if (existinguser != null) {

			Cart cart = existinguser.getCart();

			List<Product> pList = cart.getProducts();

			if (pList != null && !pList.isEmpty()) {

				System.out.println("The Product is Cart :");

				for (Product product : pList) {

					System.out.println("Product Id " + product.getProductId() + "\n Product Name:"
							+ product.getProductName() + "\n Product Brand" + product.getProductBrand()
							+ "\nProduct Price " + product.getProductPrice());

				}
			}

			else {

				System.err.println("No product Found  !!");
			}
		}

		else {

			System.err.println("User Not Found  !!");
		}

		tran.commit();
		session.close();

	}

}
