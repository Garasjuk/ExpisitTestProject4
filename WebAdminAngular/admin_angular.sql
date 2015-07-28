-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Июл 28 2015 г., 23:26
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `admin_angular`
--

-- --------------------------------------------------------

--
-- Структура таблицы `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id_group` int(11) NOT NULL AUTO_INCREMENT,
  `name_group` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_group`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Дамп данных таблицы `groups`
--

INSERT INTO `groups` (`id_group`, `name_group`) VALUES
(1, '\nscience'),
(2, 'Anime'),
(3, 'Fitnes'),
(4, 'psychology'),
(5, 'tourism'),
(6, 'Sport'),
(7, 'Computers'),
(8, 'Internet'),
(9, '\nastrology'),
(10, 'Animals'),
(11, 'Music'),
(12, 'Cinema'),
(13, '\nliterature'),
(14, 'philosophy'),
(15, 'Danсe'),
(16, 'Cars'),
(17, 'Food'),
(18, 'Medic'),
(19, 'Decign'),
(20, 'Money'),
(24, 'Extreme');

-- --------------------------------------------------------

--
-- Структура таблицы `union`
--

CREATE TABLE IF NOT EXISTS `union` (
  `id_union` int(11) NOT NULL AUTO_INCREMENT,
  `id_group` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_union`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Дамп данных таблицы `union`
--

INSERT INTO `union` (`id_union`, `id_group`, `id_user`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 2, 1),
(5, 2, 2),
(6, 3, 1),
(7, 3, 2),
(8, 3, 3),
(9, 4, 1),
(10, 4, 2),
(11, 5, 1),
(12, 5, 2),
(13, 5, 3),
(14, 6, 1),
(15, 7, 1),
(16, 8, 1),
(17, 6, 2),
(18, 9, 1),
(19, 8, 3),
(20, 10, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `unionz`
--

CREATE TABLE IF NOT EXISTS `unionz` (
  `id_union` int(11) NOT NULL AUTO_INCREMENT,
  `id_group` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_union`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=210 ;

--
-- Дамп данных таблицы `unionz`
--

INSERT INTO `unionz` (`id_union`, `id_group`, `id_user`) VALUES
(5, 2, 2),
(7, 3, 2),
(35, 7, 1),
(65, 19, 3),
(69, 1, 3),
(71, 9, 3),
(78, 16, 3),
(85, 13, 2),
(86, 9, 2),
(87, 8, 2),
(88, 19, 2),
(89, 14, 2),
(90, 2, 3),
(92, 10, 3),
(93, 5, 3),
(94, 17, 3),
(95, 18, 3),
(96, 20, 3),
(101, 2, 4),
(102, 5, 4),
(103, 8, 4),
(104, 6, 4),
(105, 14, 4),
(106, 11, 4),
(107, 17, 4),
(108, 15, 4),
(109, 12, 4),
(114, 2, 1),
(115, 1, 1),
(116, 8, 1),
(117, 5, 1),
(118, 3, 1),
(119, 18, 1),
(120, 11, 1),
(123, 5, 6),
(124, 1, 4),
(125, 3, 4),
(132, 4, 13),
(133, 4, 23),
(134, 4, 20),
(135, 4, 18),
(136, 4, 19),
(137, 4, 16),
(138, 4, 17),
(139, 4, 24),
(140, 4, 22),
(141, 4, 21),
(142, 4, 26),
(143, 4, 25),
(144, 4, 27),
(145, 4, 27),
(146, 4, 28),
(147, 4, 28),
(148, 4, 30),
(149, 4, 29),
(150, 4, 31),
(151, 4, 32),
(152, 4, 33),
(153, 4, 36),
(154, 4, 35),
(155, 4, 34),
(156, 4, 15),
(157, 4, 38),
(158, 4, 37),
(159, 4, 8),
(160, 4, 7),
(161, 4, 4),
(162, 4, 2),
(163, 15, 5),
(164, 15, 6),
(165, 15, 10),
(166, 15, 15),
(167, 15, 16),
(168, 15, 19),
(169, 15, 20),
(170, 15, 21),
(171, 15, 12),
(172, 15, 23),
(173, 15, 17),
(174, 15, 18),
(175, 15, 8),
(176, 15, 11),
(177, 15, 26),
(178, 15, 25),
(179, 16, 21),
(180, 16, 22),
(181, 16, 20),
(182, 16, 27),
(183, 16, 30),
(184, 16, 29),
(185, 16, 28),
(186, 16, 26),
(187, 16, 24),
(188, 16, 23),
(189, 16, 33),
(190, 16, 33),
(191, 16, 32),
(192, 16, 31),
(193, 16, 17),
(194, 16, 35),
(196, 18, 10),
(197, 18, 2),
(198, 18, 7),
(199, 18, 11),
(200, 18, 18),
(201, 18, 19),
(202, 18, 27),
(203, 18, 29),
(204, 18, 28),
(205, 18, 8),
(206, 18, 31),
(207, 18, 24),
(208, 18, 25),
(209, 18, 26);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=47 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id_user`, `user_name`, `first_name`, `last_name`, `email`) VALUES
(1, 'Ivanaaan', 'Иван', 'Иваноы', 'iv@mai.ru'),
(2, 'Ivannvvvaaaaaaa', 'Иванн', 'Ивановв', 'iv@mai.ru'),
(3, 'Ivannn', 'Иван', 'Иванов', 'iv@mai.ru'),
(4, 'Ivaqq', 'Ивааа', 'Иваноооо', 'iv@mai.ru'),
(5, 'Ivarr', 'Ивввв', 'Иваааааа', 'iv@mai.ru'),
(6, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(7, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(8, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(9, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(10, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(11, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(12, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(13, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(14, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(15, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(16, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(17, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(18, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(19, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(20, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(21, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(22, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(23, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(24, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(25, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(26, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(27, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(28, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(29, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(30, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(31, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(32, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(33, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(34, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(35, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(36, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(37, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(38, 'Iva', 'Иван', 'Иванов', 'iv@mai.ru'),
(39, 'Petr', 'Петр', 'Петров', 'undefined'),
(41, 'Petrovrr', 'Петрр', 'Петроввв', 'qwe@re'),
(46, 'rtyu', 'Всидоров', 'Сидрр', 'qasw@edrf');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
