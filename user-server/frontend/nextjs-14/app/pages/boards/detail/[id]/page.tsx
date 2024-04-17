'use client'

import { DataGrid } from '@mui/x-data-grid';
import { useState, useEffect } from "react"
import { NextPage } from "next";
import { useSelector, useDispatch } from 'react-redux'
import Columns from "@/app/components/board/module/columns";
import { getAllBoards, getfindBoardsById } from "@/app/components/board/service/board.slice";
import { findAllBoards, findBoardById } from "@/app/components/board/service/board.service";
import { Typography } from '@mui/material';
import { retry } from '@reduxjs/toolkit/query';



export default function BoardDetailPage ({params}:any){
const dispatch = useDispatch()
const board = useSelector(getfindBoardsById)

useEffect(()=>(dispatch(findBoardById(params.id))),[])


    return(<>
    
 <span>ID :</span>   <Typography textAlign="center" sx={{ fontSize: "1.2rem" }}>{params.id}</Typography>
    <span>게시판 타입 :</span>   <Typography textAlign="center" sx={{ fontSize: "1.2rem" }}>{board.boardType}</Typography>
    <span>등록일 :</span>   <Typography textAlign="center" sx={{ fontSize: "1.2rem" }}>{board.regDate}</Typography>
    <span>수정일 :</span>   <Typography textAlign="center" sx={{ fontSize: "1.2rem" }}>{board.modDate}</Typography>
    
    </>)




}