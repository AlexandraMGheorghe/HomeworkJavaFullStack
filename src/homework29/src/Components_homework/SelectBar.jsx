import styled from "styled-components";
import {useState} from "react";
import Repos from "./Repos";
// import Select from 'react-select';
import {NavLink, useNavigate} from "react-router-dom";
import Select, { SelectChangeEvent } from '@mui/material/Select';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import * as React from 'react';

// export const MyComp = () => (
//     <Select options = {Repos.id}/>
// )
//
export const SelectBar = () => {
    const [isOpen, setIsOpen] = useState(false);
    const [selectedOption, setSelectedOption] = useState(null);
    const navigate = useNavigate();

    const toggling = () => setIsOpen(!isOpen);

    const onOptionClicked = value => () => {
        setSelectedOption(value);
        setIsOpen(false);
        console.log(selectedOption);
        navigate("../repos/{option.id}");
    };

    return(
        <DropDownContainer>
            <DropDownHeader onClick={toggling}>Repos</DropDownHeader>
            {isOpen && (
                <DropDownListContainer>
                    <DropDownList>
                        {Repos.map(option => (
                                <ListItem onClick={onOptionClicked(option.id)} key={Math.random()}>
                                    {option.id}
                                </ListItem>
                            )
                        )}
                    </DropDownList>
                </DropDownListContainer>
            )}
        </DropDownContainer>
    )}

const DropDownContainer = styled("div")`
  width: 10.5em;
  margin: 0 auto;
`;

const DropDownHeader = styled("div")`
  margin-bottom: 0.8em;
  padding: 0.4em 2em 0.4em 1em;
  box-shadow: 0 2px 3px rgba(0, 0, 0, 0.15);
  font-weight: 500;
  font-size: 1.3rem;
  color: #3faff;
  background: #ffffff;
`;

const DropDownListContainer = styled("div")``;

const DropDownList = styled("ul")`
  padding: 0;
  margin: 0;
  padding-left: 1em;
  background: #ffffff;
  border: 2px solid #e5e5e5;
  box-sizing: border-box;
  color: #3faff;
  font-size: 1.3rem;
  font-weight: 500;
  &:first-child {
    padding-top: 0.8em;
  }
`;

const ListItem = styled("li")`
  list-style: none;
  margin-bottom: 0.8em;
`;