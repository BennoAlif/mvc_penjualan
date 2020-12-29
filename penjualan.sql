-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Waktu pembuatan: 23. Juli 2017 jam 06:00
-- Versi Server: 5.5.16
-- Versi PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `penjualan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(25) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `keterangan` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id`, `kode`, `nama`, `harga`, `jumlah`, `keterangan`) VALUES
(4, '0001', 'shampo', 5500, 38, '-'),
(5, '0002', 'sabun', 1500, 30, '-'),
(6, '0003', 'pepsodent', 0, 0, '-');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE IF NOT EXISTS `pelanggan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(25) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `hp` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `kode`, `nama`, `alamat`, `hp`) VALUES
(1, '123', 'abdul', 'praya', 8190283);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE IF NOT EXISTS `pembelian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` date NOT NULL,
  `kode_suplier` varchar(25) NOT NULL,
  `kode_barang` varchar(25) NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `harga_total` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`id`, `tanggal`, `kode_suplier`, `kode_barang`, `jumlah_barang`, `harga_barang`, `harga_total`) VALUES
(9, '2017-06-01', '001', '0001', 10, 1500, 15000),
(10, '2017-06-01', '001', '0002', 15, 5000, 75000),
(11, '2017-06-01', '001', '0002', 5, 5000, 25000),
(12, '2017-06-01', '002', '0001', 15, 1500, 22500),
(13, '2017-06-01', '002', '0002', 4, 1500, 6000),
(14, '2017-06-01', '002', '0002', 6, 6000, 36000),
(15, '2017-06-02', '001', '0001', 10, 4000, 40000),
(16, '2017-06-02', '001', '0002', 10, 4000, 40000),
(17, '2017-06-02', '001', '0001', 4, 5500, 22000),
(18, '2017-06-02', '001', '0002', 2, 2500, 5000),
(19, '2017-06-02', '-', '0002', 2, 1500, 3000),
(20, '2017-06-02', '-', '0002', 2, 1500, 3000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE IF NOT EXISTS `pengguna` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `pass` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`id`, `nama`, `pass`) VALUES
(1, 'admin', 'b30e4c80db9f696c1094a6f4ee31162cf2a8d207a3f75867064d3f60da436e7a68f92a25be632271ea40a62d5be83a5bf75297bcd58ffdaf6c5ae5fa37dd5e7d');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE IF NOT EXISTS `penjualan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` date NOT NULL,
  `kode_pelanggan` varchar(25) NOT NULL,
  `kode_barang` varchar(25) NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`id`, `tanggal`, `kode_pelanggan`, `kode_barang`, `jumlah_barang`, `harga_barang`, `total_harga`) VALUES
(3, '2017-06-01', '123', '0001', 10, 6000, 60000),
(4, '2017-06-01', '123', '0002', 10, 6000, 60000),
(5, '2017-06-02', '123', '0001', 4, 6000, 24000),
(6, '2017-06-02', '123', '0002', 2, 1500, 3000),
(7, '2017-06-02', '123', '0001', 5, 1500, 7500),
(8, '2017-06-02', '123', '0001', 2, 5500, 11000),
(9, '2017-06-02', '-', '0002', 4, 2500, 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `suplier`
--

CREATE TABLE IF NOT EXISTS `suplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(25) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `hp` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `suplier`
--

INSERT INTO `suplier` (`id`, `kode`, `nama`, `alamat`, `hp`) VALUES
(1, '001', 'jalal', 'praya', 182938);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmp_pembelian`
--

CREATE TABLE IF NOT EXISTS `tmp_pembelian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` date NOT NULL,
  `kode_suplier` varchar(25) NOT NULL,
  `kode_barang` varchar(25) NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tmp_penjualan`
--

CREATE TABLE IF NOT EXISTS `tmp_penjualan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` date NOT NULL,
  `kode_pelanggan` varchar(25) NOT NULL,
  `kode_barang` varchar(25) NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
