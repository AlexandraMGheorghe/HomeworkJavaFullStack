import { Modal } from '@mui/material';
import { useState } from 'react';
import bookData from './books.json';
import './BooksTable.css';

const tableHeader = ["ID", "TITLE", "AUTHOR", "GENRE", "DESCRIPTION"];

const BooksTable = () => {
    const [open, setOpen] = useState(false);
    const [bookImg, setBookImg] = useState(undefined);

    const handleOpen = (bookImage) => {
        setOpen(true);
        setBookImg(bookImage);
    }

    return (
        <div>
            <div className="books-table">
                <div className="books-table-row">
                    {tableHeader.map((header) => (
                        <div key={header} className="books-table-header">{header}</div>
                    ))}
                </div>
                {bookData.map((book) => (
                    <div key={book.id} className="books-table-row">
                        {Object.entries(book).map(([key, value]) => (
                            tableHeader.includes(key.toLocaleUpperCase()) &&
                            <div key={`${key}-${book.id}`} className="books-table-col" onClick={() => handleOpen(book.image)}>{value}</div>
                        ))}
                    </div>
                ))}
            </div>
            <Modal
                open={open}
                onClose={() => setOpen(false)}
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                style={{display:'flex', alignItems:'center', justifyContent:'center'}}>
                <img src={bookImg} style={{padding:'30px 200px 30px 200px', backgroundColor: 'white'}} />
            </Modal>
        </div>
    );
};

export default BooksTable;