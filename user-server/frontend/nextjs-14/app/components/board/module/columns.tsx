import Typography from "@mui/material/Typography";
import { GridColDef } from "@mui/x-data-grid";
import { IBoard } from "../model/board.model";
import Link from "next/link";
import { PG } from "../../common/enums/PG";
interface CellType{
    row : IBoard

}
export default function Columns() : GridColDef[]{

    return [
        {
            flex:0.04,
            field: 'id',
            minWidth: 30,
            sortable:false,
            headerName: 'ID',
            renderCell:({row}:CellType) => <Typography textAlign="center" sx={{ fontSize: "1.2rem" }}>{row.id}</Typography>
        },
        {
            flex:0.04,
            field: 'boardType',
            minWidth: 30,
            sortable:false,
            headerName: 'boardType',
            renderCell:({row}:CellType) => <Typography textAlign="center" sx={{ fontSize: "1.2rem" }}>
                <Link href={`${PG.BORAD}/detail/${row.id}`}>{row.boardType}</Link></Typography>
        },
       
    ]
}