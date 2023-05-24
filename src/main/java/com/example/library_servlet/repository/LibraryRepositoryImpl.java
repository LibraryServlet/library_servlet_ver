package com.example.library_servlet.repository;


import com.example.library_servlet.entity.Library;
import com.example.library_servlet.repository.db.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LibraryRepositoryImpl implements LibraryRepository {

    Connection conn;

    @Override
    public void insert(Library library) {
        String sql = "insert into library (name, author, publisher, isbn, release_year, count, summary, image, category) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = ConnectionManager.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, library.getName());
            pstmt.setString(2, library.getAuthor());
            pstmt.setString(3, library.getPublisher());
            pstmt.setString(4, library.getIsbn());
            pstmt.setInt(5, library.getReleaseYear());
            pstmt.setInt(6, library.getCount());
            pstmt.setString(7, library.getSummary());
            pstmt.setString(8, library.getImage());
            pstmt.setString(9, library.getCategory());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Library> findAll() {
        String sql = "select * from library";
        try {
            conn = ConnectionManager.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql);

            return executeQuery(pstmt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Library findById(Long id) {
        String sql = "select * from library where id = ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            return executeQuery(pstmt).get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Library> findByName(String name) {
        String sql = "select * from library where name like ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            return executeQuery(pstmt);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Library> findByAuthor(String author) {
        String sql = "select * from library where author like ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + author + "%");
            return executeQuery(pstmt);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Library> findByPublisher(String publisher) {
        String sql = "select * from library where publisher like ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + publisher + "%");
            return executeQuery(pstmt);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Library> findByIsbn(String isbn) {
        String sql = "select * from library where isbn like ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + isbn + "%");
            return executeQuery(pstmt);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Library> findByCategory(String category) {
        String sql = "select * from library where category like ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + category + "%");
            return executeQuery(pstmt);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void countPlus(Long id, int count) {
        String sql = "update library set count = count + ? where id = ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, count);
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
        } catch (Exception ignored) {

        }
    }

    @Override
    public void countMinus(Long id, int count) {
        String sql = "update library set count = count - ? where id = ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, count);
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
        } catch (Exception ignored) {

        }
    }

    @Override
    public void deleteById(Long id) {
        String sql = "delete from library where id = ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (Exception ignored) {

        }
    }

    public void updateLibrary(Library library) {
        String sql = "update library set " +
                "name = ?, author = ?, publisher = ?, isbn = ?, release_year = ?, summary = ?, image = ?, category = ? where id = ?";
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, library.getName());
            pstmt.setString(2, library.getAuthor());
            pstmt.setString(3, library.getPublisher());
            pstmt.setString(4, library.getIsbn());
            pstmt.setInt(5, library.getReleaseYear());
            pstmt.setString(6, library.getSummary());
            pstmt.setString(7, library.getImage());
            pstmt.setString(8, library.getCategory());
            pstmt.setLong(9, library.getId());


            pstmt.executeUpdate();
        } catch (Exception ignored) {

        }
    }

    private List<Library> executeQuery(PreparedStatement pstmt) {
        List<Library> libraryList = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                libraryList.add(new Library(Long.parseLong(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), Integer.parseInt(rs.getString(6)), Integer.parseInt(rs.getString(7)),
                        rs.getString(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                Objects.requireNonNull(rs).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Objects.requireNonNull(pstmt).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return libraryList;
    }

//    private void executeUpdate(PreparedStatement pstmt) {
//        try {
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                Objects.requireNonNull(pstmt).close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
