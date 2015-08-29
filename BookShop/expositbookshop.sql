-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Авг 29 2015 г., 15:36
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `expositbookshop`
--

-- --------------------------------------------------------

--
-- Структура таблицы `author`
--

CREATE TABLE IF NOT EXISTS `author` (
  `id_author` int(11) NOT NULL AUTO_INCREMENT,
  `name_author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_author`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Дамп данных таблицы `author`
--

INSERT INTO `author` (`id_author`, `name_author`) VALUES
(1, 'AYN RAND'),
(2, 'ERNEST HEMINGWAY'),
(3, 'JOAN DIDION'),
(4, 'RAY BRADBURY'),
(5, 'GEORGE R.R. MARTIN'),
(6, 'GILLIAN FLYNN'),
(7, 'LADIMIR NABOKOV'),
(8, 'JANE AUSTEN'),
(9, 'MARK TWAIN');

-- --------------------------------------------------------

--
-- Структура таблицы `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id_book` int(11) NOT NULL AUTO_INCREMENT,
  `name_book` varchar(50) DEFAULT NULL,
  `count_book` int(11) DEFAULT NULL,
  `price_book` int(11) DEFAULT NULL,
  `id_genre` int(11) DEFAULT NULL,
  `id_author` int(11) DEFAULT NULL,
  `new_book` int(11) DEFAULT NULL,
  `id_publishing` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_book`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Дамп данных таблицы `book`
--

INSERT INTO `book` (`id_book`, `name_book`, `count_book`, `price_book`, `id_genre`, `id_author`, `new_book`, `id_publishing`) VALUES
(1, 'The Hunger Games', 1, 122, 1, 1, 1, 1),
(2, 'To Kill a Mockingbird', 1, 122, 1, 1, 1, 1),
(3, 'Pride and Prejudice', 3, 50, 2, 2, 1, 3),
(4, 'Gone with the Wind', 3, 40, 2, 2, 1, 3),
(5, 'Harry Potter and the Order of the Phoenix', 5, 100, 1, 2, 1, 3),
(6, 'Gone with the Wind', 2, 30, 2, 2, 0, 3),
(7, 'Harry Potter and the Order of the Phoenix', 1, 80, 1, 2, 0, 3),
(8, 'The Hunger Games', 2, 97, 1, 1, 0, 1),
(9, 'The Book Thief', 4, 50, 2, 2, 1, 4),
(10, 'Wuthering Heights', 3, 60, 3, 3, 1, 5);

-- --------------------------------------------------------

--
-- Структура таблицы `cart`
--

CREATE TABLE IF NOT EXISTS `cart` (
  `id_cart` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `count_cart` int(11) NOT NULL,
  PRIMARY KEY (`id_cart`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Дамп данных таблицы `cart`
--

INSERT INTO `cart` (`id_cart`, `id_book`, `id_user`, `count_cart`) VALUES
(2, 4, 6, 1),
(4, 3, 6, 1),
(5, 6, 6, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `coments`
--

CREATE TABLE IF NOT EXISTS `coments` (
  `id_coment` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `opinion_coment` varchar(1000) DEFAULT NULL,
  `date_coment` date DEFAULT NULL,
  PRIMARY KEY (`id_coment`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Дамп данных таблицы `coments`
--

INSERT INTO `coments` (`id_coment`, `id_book`, `id_user`, `opinion_coment`, `date_coment`) VALUES
(1, 1, 1, 'bla bla bla', '2015-08-03'),
(2, 1, 2, 'Da DA Da', '2015-08-05'),
(3, 1, 3, 'Nu NU nU', '2015-08-06'),
(4, 2, 1, NULL, '2015-08-11'),
(5, 2, 1, 'Very goÐ² book', '2015-08-11'),
(6, 2, 1, 'Very gooood book', '2015-08-11'),
(7, 2, 6, 'Yes, god bok', '2015-08-12'),
(8, 2, 6, 'I like it', '2015-08-12'),
(9, 4, 6, 'No, nothing interesting', '2015-08-12'),
(10, 5, 1, 'Good film', '2015-08-17'),
(11, 5, 6, 'Yes is good', '2015-08-17'),
(12, 3, 5, 'eqwc zc', '2015-08-27');

-- --------------------------------------------------------

--
-- Структура таблицы `genre`
--

CREATE TABLE IF NOT EXISTS `genre` (
  `id_genre` int(11) NOT NULL AUTO_INCREMENT,
  `name_genre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_genre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Дамп данных таблицы `genre`
--

INSERT INTO `genre` (`id_genre`, `name_genre`) VALUES
(1, 'Fantasy'),
(2, 'Religious'),
(3, 'Crime'),
(4, 'Romance'),
(5, 'Horror');

-- --------------------------------------------------------

--
-- Структура таблицы `likes`
--

CREATE TABLE IF NOT EXISTS `likes` (
  `id_like` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_like`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=30 ;

--
-- Дамп данных таблицы `likes`
--

INSERT INTO `likes` (`id_like`, `id_book`, `id_user`) VALUES
(1, 3, 1),
(2, 3, 2),
(3, 3, 1),
(4, 3, 1),
(5, 3, 1),
(7, 1, 1),
(9, 5, 1),
(14, 2, 6),
(16, 5, 6),
(18, 1, 6),
(19, 3, 6),
(21, 4, 6),
(22, 5, 5),
(23, 6, 1),
(24, 6, 6),
(25, 7, 8),
(29, 3, 5);

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `count_order` int(11) DEFAULT NULL,
  `adres_order` varchar(250) DEFAULT NULL,
  `date_order` date DEFAULT NULL,
  `other_order` varchar(500) DEFAULT NULL,
  `status_order` varchar(20) DEFAULT NULL,
  `date_delivered` date DEFAULT NULL,
  `return_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`id_order`, `id_book`, `id_user`, `count_order`, `adres_order`, `date_order`, `other_order`, `status_order`, `date_delivered`, `return_order`) VALUES
(2, 1, 5, 1, 'Vitebsk', '2015-08-14', 'ok', 'delivered', '2015-08-20', 1),
(6, 3, 2, 1, 'Gomel', '2015-08-11', 'good', 'delivered', '2015-08-20', 0),
(8, 4, 5, 1, 'Vitebsk', '2015-08-14', 'da', 'delivered', '2015-08-20', 1),
(10, 2, 5, 1, 'Vitebsk', '2015-08-14', 'cool', 'delivered', '2015-08-20', 1),
(11, 5, 5, 1, 'Vitebsk', '2015-08-18', 'yes', 'delivered', '2015-08-20', 1),
(12, 4, 5, 1, 'Vitebsk', '2015-08-20', 'ok', 'delivered', '2015-08-20', 1),
(13, 5, 5, 1, 'Vitebsk', '2015-08-20', 'yes', 'in processing', NULL, 0),
(14, 7, 8, 1, 'Grodno, Ltnina 1', '2015-08-26', 'yes', 'delivered', '2015-08-26', 1),
(15, 7, 8, 1, 'Grodno, Ltnina 1', '2015-08-26', 'yes', 'delivered', '2015-08-26', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `publishing`
--

CREATE TABLE IF NOT EXISTS `publishing` (
  `id_publishing` int(11) NOT NULL AUTO_INCREMENT,
  `name_publishing` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_publishing`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Дамп данных таблицы `publishing`
--

INSERT INTO `publishing` (`id_publishing`, `name_publishing`) VALUES
(1, ' 	Pearson'),
(2, ' 	Reed Elsevier'),
(3, 'Thomson Reuters'),
(4, ' 	Wolters Kluwer'),
(5, ' 	Hachette Livre'),
(6, 'McGraw-Hill Education'),
(7, 'Random House'),
(8, ' 	Holtzbrinck'),
(9, 'Cengage Learning');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name_user` varchar(50) DEFAULT NULL,
  `money_user` int(11) DEFAULT NULL,
  `adres_user` varchar(250) DEFAULT NULL,
  `pass_user` varchar(32) DEFAULT NULL,
  `identif` varchar(2) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `spend_money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id_user`, `name_user`, `money_user`, `adres_user`, `pass_user`, `identif`, `email`, `spend_money`) VALUES
(1, 'Admin', 5, 'Garodnia', '202cb962ac5975b964b7152d234b70', '1', 'suport@shopbook.net', 1),
(2, 'val', 87, 'Grodno', 'c4ca4238a0b92382dcc509a6f75849b', '0', 'val@mail.ru', 1),
(3, 'Penro', 45, 'Brest', 'c4ca4238a0b92382dcc509a6f75849b', '0', 'Petrov@list.ru', 1),
(4, 'Penrov', 90, 'Minsk', 'c4ca4238a0b92382dcc509a6f75849b', '0', 'SDP@mail.ru', 1),
(5, 'Alex', 32, 'Vitebsk', 'c4ca4238a0b92382dcc509a6f75849b', '0', 'qwe@ed.ty', 1),
(6, 'Fox', 0, 'Gomel', 'c4ca4238a0b92382dcc509a6f75849b', '0', 'rew@ed.tt', 1),
(7, 'Jeck', 0, 'New yourk', 'c4ca4238a0b92382dcc509a6f75849b', '0', 'new@yourk.com', 1),
(8, 'Feel', 29, 'Grodno, Ltnina 1', 'c4ca4238a0b92382dcc509a6f75849b', '0', 'feel@mail.ru', 41);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
